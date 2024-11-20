package com.busanit501.helloworld.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginInputController", urlPatterns = "/login/input")
public class LoginInputController extends HttpServlet  {
    // 화면 접근 -> get 으로 접근.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 업무, 화면으로 전달해주느게,
        //요청을 받고, 화면으로 전달 해주는 역할.
        // 이동할 화면만 수정.
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/login/login_input.jsp");
        dispatcher.forward(request,response);
    }
}
