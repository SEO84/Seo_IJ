package com.busanit501.helloworld.calc;

// 입력화면 접근은, jsp 파일에 직접 접근 안하고,
// http://localhost:8080/calc/input -> 서블릿에 접근.
// 서블릿(자바파일) -> 뷰화면(jsp 파일)로 전달해줌.
// 결론, 웹브라우저 입장에서, 입력 화면 도착.

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 입력 화면에서, 폼 -> action -> 서버에 전달하는 주소를 서블릿 url 주소로 변경.
// 변경 전 : 결과 화면 페이지에 직접 접근.
// 변경 후 : 서블릿(자바파일) 경유해서, 결과 화면으로 이동함.
@WebServlet(name = "calcResultController", urlPatterns = "/calc/result")
public class CalcResultController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 쿼리 스트링 ,
        // http://localhost:8080/calc/calc_input.jsp?num1=111&num2=1111
        // 화면에서 전달된 파라미터를 가져오는 메서드, 키와 값의 구조
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");

        System.out.println("num1 : " + num1 + " num2 : " + num2);

//        결과 화면을 다른 뷰로 전달함
        // 리다이렉트로, 직접 화면에 또 접근했음.
        // 결론, 화면에 직접 접근 못하게 /WEB-INF 넣어 둠. 그래서, 접근이 안됨.
        // 서블릿을 만들어서, 결과 화면을 처리하는 로직이 필요함.
//        response.sendRedirect("/WEB-INF/calc/calc_result.jsp");
        response.sendRedirect("/calc/input");
    }
}
