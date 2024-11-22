package com.busanit501.helloworld.jdbcex.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

//롬복 사용하기.
//@Getter
//@Setter
//@ToString
@Data
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
