package com.dto.member;

import lombok.Data;

@Data
public class MemberUpdateAllDto {
    private String loginId; // 로그인 아이디

    private String name; // 회원의 이름

    private String email; // 이메일
}
