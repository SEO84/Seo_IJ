package com.busanit501.helloworld.food;

import com.busanit501.helloworld.food.dao.FoodDAO;
import com.busanit501.helloworld.food.vo.FoodVO;
import com.busanit501.helloworld.jdbcex.dao.TodoDAO;
import com.busanit501.helloworld.jdbcex.dto.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;


public class FoodDAOTest {
    private FoodDAO foodDAO;

    // 아래에 각 단위 테스트가 실행되기전에, 먼저 실행을 함.
    @BeforeEach
    public void ready() {
        foodDAO = new FoodDAO();
    }

    @Test
    public void getTime() {
        System.out.println("sql 전달 후, 시간 조회 확인용: " + foodDAO.getTime());
    }

    @Test
    public void getTime2() throws SQLException {
        System.out.println("sql 전달 후, " +
                "시간 조회 확인용: 자동 반납 @Cleanup 확인 " + foodDAO.getTime2());
    }

    @Test
    public void insetTest() throws Exception {
        FoodVO foodVO = FoodVO.builder()
                .title("샘플 데이터 추가1")
                .dueDate(LocalDate.now())
                .finished(false)
                .build();

        foodDAO.insert(foodVO);

    }
}
