package com.busanit501.helloworld.food;

import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.service.FoodService;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.service.TodoService;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Log4j2
public class FoodServiceTest {
    private FoodService foodService;

    @BeforeEach
    public void ready() {
        foodService = FoodService.INSTANCE;
    }

    // 등록
    @Test
    public void testInsert() throws SQLException {
        // 더미 데이터, 화면에서 전달 받은 TodoDTO
        FoodDTO foodDTO = FoodDTO.builder()
                .title("샘플 작업 1127, 1교시")
                .dueDate(LocalDate.now())
                .build();
        foodService.register(foodDTO);
    }

    // 전체 조회
    @Test
    public void testSelectAll() throws SQLException {
         List<FoodDTO> dtoList = foodService.listAll();
        for (FoodDTO foodDTO:dtoList) {
            log.info(foodDTO);
        }
    }

    // 하나조회, 상세보기.
    @Test
    public void testSelectOne() throws SQLException {
        FoodDTO foodDTO = foodService.get(9L);
        log.info("하나 조회. foodDTO " + foodDTO);
    }


}
