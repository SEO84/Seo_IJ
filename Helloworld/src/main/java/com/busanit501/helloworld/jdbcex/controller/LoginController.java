package com.busanit501.helloworld.jdbcex.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "LoginController" , urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("LoginController doGet ");
        request.getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request,response);
    }
}
