package com.service;

import com.domain.Member;
import com.dto.TokenInfoDto;
import com.dto.member.MemberDto;
import com.dto.member.MemberJoinDto;
import com.dto.member.MemberLoginDto;
import com.exception.InvalidPasswordException;
import com.exception.MemberDuplicateException;
import com.exception.NotFoundException;
import com.repository.MemberRepository;
import com.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class AuthService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public String join(MemberJoinDto memberInfo){
        // loginID 중복 확인
        memberRepository.findByLoginId(memberInfo.getLoginId())
                .ifPresent(u -> {
                    throw new MemberDuplicateException("ID '" + memberInfo.getLoginId()+"' is already existed.");
                });

        Member member = Member.builder()
                .loginId(memberInfo.getLoginId())
                .password(encoder.encode(memberInfo.getPassword()))
                .email(memberInfo.getEmail())
                .name(memberInfo.getName())
                .phoneNo(memberInfo.getPhoneNo())
                .build();

        memberRepository.save(member);
        return member.getLoginId();
    }

    public Boolean checkDuplicate(String loginId){
        // loginID 중복 확인
        memberRepository.findByLoginId(loginId)
                .ifPresent(u -> {
                    throw new MemberDuplicateException("ID '" + loginId+"' is already existed.");
                });

        return true;
    }



    private static List<MemberDto> convertMemberToMemberDto(List<Member> memberList) {
        List<MemberDto> memberDtoList = memberList.stream()
                .map(a -> new MemberDto(a))
                .collect(Collectors.toList());
        return memberDtoList;
    }



    @Transactional
    public TokenInfoDto login(MemberLoginDto memberInfo) {
        // userName X
        Member selectedMember = memberRepository.findByLoginId(memberInfo.getLoginId())
                .orElseThrow(() -> new NotFoundException("Member not found with loginId: " + memberInfo.getLoginId()));
        // password wrong
        if(!encoder.matches(memberInfo.getPassword(), selectedMember.getPassword())) {
            throw new InvalidPasswordException("This is wrong password.");
        }
        log.info("memberInfo = {}", memberInfo);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberInfo.getLoginId(), memberInfo.getPassword());

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        log.info("TokenInfo  authentication = {}", authentication);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfoDto tokenInfo = jwtTokenProvider.generateToken(authentication);

        return tokenInfo;
    }

}
