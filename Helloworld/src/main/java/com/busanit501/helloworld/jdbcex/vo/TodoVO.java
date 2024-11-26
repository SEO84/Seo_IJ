package com.busanit501.helloworld.jdbcex.vo;

import lombok.*;

import java.time.LocalDate;

//롬복 사용하기.
//@Getter
//@Setter
//@ToString
// VO(Value Object)
// 사용 용도, 직접적인 데이터베이스에 반영하는 클래스
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
