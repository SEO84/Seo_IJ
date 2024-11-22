package com.busanit501.helloworld.jdbcex;

import com.busanit501.helloworld.jdbcex.dao.TodoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TodoDAOTest {
    private TodoDAO todoDAO;

    // 아래에 각 단위 테스트가 실행되기전에, 먼저 실행을 함.
    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void getTime() {
        System.out.println("sql 전달 후, 시간 조회 확인용: "+todoDAO.getTime());
    }

    @Test
    public void getTime2() throws SQLException {
        System.out.println("sql 전달 후, " +
                "시간 조회 확인용: 자동 반납 @Cleanup 확인 "+todoDAO.getTime2());
    }
}
