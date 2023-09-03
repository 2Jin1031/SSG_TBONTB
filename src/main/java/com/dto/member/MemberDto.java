package com.dto.member;

import com.domain.Member;
import lombok.Data;

@Data
public class MemberDto {
    private Long id;

    private String loginId; // 로그인 아이디

    private String name; // 회원의 이름

    private String email; // 이메일

    public MemberDto(Member member) {
        this.id = member.getId();
        this.loginId = member.getLoginId();
        this.name = member.getName();
        this.email = member.getEmail();
    }

    public MemberDto() {
    }
}
