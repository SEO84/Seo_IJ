package com.busanit501.helloworld.jdbcex.vo;

import lombok.*;

import java.time.LocalDate;

//롬복 사용하기.
//@Getter
//@Setter
//@ToString
@Data
@Builder
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
