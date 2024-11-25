package com.busanit501.helloworld.food.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

//롬복 사용하기.
//@Getter
//@Setter
//@ToString
@Data
@Builder
public class FoodVO {
    private Long fno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
