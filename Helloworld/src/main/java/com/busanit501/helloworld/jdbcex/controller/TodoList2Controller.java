package com.busanit501.helloworld.jdbcex.controller;

import com.busanit501.helloworld.jdbcex.service.TodoService;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Log4j2 // log.info("이런 형식으로 출력 한다.")
@WebServlet(name = "TodoList2Controller", urlPatterns = "/todo/list2")
public class TodoList2Controller extends HttpServlet {
    // 외주 일 시키기, 누구? 서비스 한테, 선언만,
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //
        log.info("doGet TodoList2Controller 확인");
        try {
            // 서비스에 외주 주고, 전체 목록 리스트 받아오기.
            List<TodoDTO> todoList = todoService.listAll();
            // 화면에 데이터 전달. + 화면에 데이터 탑재된 화면을 -> 웹브라우저에게 전달.
            request.setAttribute("list", todoList);
            request.getRequestDispatcher("/WEB-INF/todo/todoList2.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
