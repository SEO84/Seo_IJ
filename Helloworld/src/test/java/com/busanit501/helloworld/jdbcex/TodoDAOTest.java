package com.busanit501.helloworld.jdbcex;

import com.busanit501.helloworld.jdbcex.dao.TodoDAO;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class TodoDAOTest {
    private TodoDAO todoDAO;

    // 아래에 각 단위 테스트가 실행되기전에, 먼저 실행을 함.
    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void getTime() {
        System.out.println("sql 전달 후, 시간 조회 확인용: " + todoDAO.getTime());
    }

    @Test
    public void getTime2() throws SQLException {
        System.out.println("sql 전달 후, " +
                "시간 조회 확인용: 자동 반납 @Cleanup 확인 " + todoDAO.getTime2());
    }

    // 1
    @Test
    public void insetTest() throws Exception {
        //원래 화면에서 데이터를 입력 받아 와서, 모델에 담고,
        // 모델에서 꺼내지만,
        // 임의로 더미 데이터 사용함.

        // 기본 인스턴스 사용하는 방법
//        TodoVO todoVO = new TodoVO();
//        todoVO.setTitle("오늘 점심 뭐 먹었나요?");
//        todoVO.setDueDate(LocalDate.of(2024, 12, 31));

        // Builder 패턴으로 인스턴스 만드는 방법.
        // 롬복에서 지원해주는 기능이라서, @Builder , TodoVO에 클래스 선언부에 작성.
        TodoVO todoVO1 = TodoVO.builder()
                .title("샘플 디비 작성 테스트")
                .dueDate(LocalDate.of(2024, 12, 31))
                .build();

        todoDAO.insert(todoVO1);

    }

    //2, 전체 목록 조회 테스트
    @Test
    public void testList() throws SQLException {
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(vo -> System.out.println(vo));
    }

    //3, 하나 조회 테스트
    @Test
    public void getOneTest() throws SQLException {
       Long tno = 3L;
       TodoVO todoVO = todoDAO.selectOne(tno);
       System.out.println(todoVO);
    }

    // 4, 삭제 테스트
    @Test
    public void deleteTest() throws SQLException {
        Long tno = 4L;
        todoDAO.deleteTodo(tno);
    }

    // 4, 수정 테스트
    @Test
    public void updateTest() throws SQLException {
        // 실제 작업은 내용을 화면에서 받아오는 대신,
        // 하드 코딩으로 값을 더미로 테스트.
        TodoVO todoVO = TodoVO.builder()
                .tno(3L)
                .title("수정 테스트 중")
                .finished(true)
                .dueDate(LocalDate.of(2024, 11, 25))
                .build();

        todoDAO.updateOne(todoVO);

    }

}// class

