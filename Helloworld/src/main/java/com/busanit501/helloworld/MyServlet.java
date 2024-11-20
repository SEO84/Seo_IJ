package com.busanit501.helloworld;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 웹브라우저에서
// http://localhost:8080/my , 요청하면,
// 지금 이 클래스가 받는 역할. 
@WebServlet(name = "myServlet" , urlPatterns = "/my")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 현재, 이 자바 파일은 역할이, 서블릿 역할.
        // 간단히, 자바 파일,
        // 업무 : 웹브라우저로부터의 요청을 받고 응답 해주는 역할. 중간 역할.
        // 컨트롤러가 대신 이역할 을 할 예정.

        // 응답, 서버 -> 웹브라우저 응답. 웹 브라우저, text/html
        resp.setContentType("text/html");

        // 출력 인스턴스 이용해서, 웹브라우저에게 응답할 준비.
        PrintWriter out = resp.getWriter();

        // 응답할 내용을 작성, 받는 쪽에서는 사용하는 언어 html
        out.println("<html><body>");
        out.println("<h1>MyServlet Test 이상용!</h1>");
        out.println("</body></html>");
    }

}
