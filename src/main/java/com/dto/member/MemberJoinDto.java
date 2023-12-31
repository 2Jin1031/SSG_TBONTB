package com.dto.member;

import com.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter @ToString
public class MemberJoinDto {
    private String loginId; // 로그인 아이디

    private String password;

    private String name; // 회원의 이름

    private String phoneNo; // 전화번호

    private String email; // 이메일

    public MemberJoinDto(Member member) {
        this.loginId = member.getLoginId();
        this.name = member.getName();
        this.phoneNo = member.getPhoneNo();
        this.email = member.getEmail();
    }

}
