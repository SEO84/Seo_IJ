package com.busanit501.helloworld.jdbcex;

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
public class TodoServiceTest {
    private TodoService todoService;

    @BeforeEach
    public void ready() {
        todoService = TodoService.INSTANCE;
    }

    // 등록
    @Test
    public void testInsert() throws SQLException {
        // 더미 데이터, 화면에서 전달 받은 TodoDTO
        TodoDTO todoDTO = TodoDTO.builder()
                .title("샘플 작업 1126")
                .dueDate(LocalDate.now())
                .build();
        todoService.register(todoDTO);
    }

    // 전체 조회
    @Test
    public void testSelectAll() throws SQLException {
         List<TodoDTO> dtoList = todoService.listAll();
        for (TodoDTO todoDto:dtoList) {
            log.info(todoDto);
        }
    }

    // 하나조회, 상세보기.
    @Test
    public void testSelectOne() throws SQLException {
        val todoDTO = todoService.get(14L);
        log.info("하나 조회. todoDTO " + todoDTO);
    }

    // 하나수정,
    @Test
    public void testUpdateOne() throws SQLException {
        //
        TodoDTO todoDTO = TodoDTO.builder()
                .tno(14L)
                .title("수정된 내용입니다.")
                .dueDate(LocalDate.now())
                .finished(false)
                .build();

        todoService.update(todoDTO);
    }

    // 하나삭제,
    @Test
    public void testDelteOne() throws SQLException {
    todoService.delete(18L);
    }
}
