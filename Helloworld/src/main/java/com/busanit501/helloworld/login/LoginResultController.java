package com.busanit501.helloworld.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginResultController", urlPatterns = "/login/result")
public class LoginResultController extends HttpServlet {
    // 화면 요청?, 로직 처리?
    // 로직 처리, get? , post?
    // post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 원래 로그인,
        // 디비에서, 유저가 존재, 입력한 유저가, 디비에서 있는지 확인. 후
        // 메인 페이지 로 이동 리다이렉트.
        // 실패, 로그인 페이지 이동, 리다이렉트,
        System.out.println("doPost,LoginResultController 서블릿을 경유해서, 로직처리합니다.");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 아직, 화면에, 모델 객체 탑재해서, 화면에 출력하는 방법.
        // 수동으로 데이터를 화면에 출력 해보기.
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> username: " + username + "</h1>");
        out.println("<h1> password: " + password + "</h1>");
        out.println("</body></html>");

    }
}
