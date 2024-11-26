package com.busanit501.helloworld.jdbcex.controller;

import com.busanit501.helloworld.jdbcex.service.TodoService;
import com.busanit501.helloworld.todo.dto.TodoDTO;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j2 // log.info("이런 형식으로 출력 한다.")
@WebServlet(name = "TodoList2Controller",urlPatterns = "/todo/list2")
public class TodoList2Controller extends HttpServlet {
    // 외주 일 시키기, 누구? 서비스 한테, 선언만,
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //
log.info("doGet TodoList2Controller 확인");
//        List<TodoDTO> todoList = TodoService.INSTANCE.getList();
//        request.setAttribute("list", todoList);
        request.getRequestDispatcher("/WEB-INF/todo/todoList2.jsp")
                .forward(request, response);
    }
}
