package com.busanit501.helloworld.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 멤버의 파라미터로 다 이용한 생성자.

public class MemberDTO {
    private Long mno;
    private String name;
    private String email;
    private LocalDate birthDate;
    private boolean active;
}

