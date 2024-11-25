package com.busanit501.helloworld.food.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data //get,set,toString,hashCode, equals
public class FoodDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
