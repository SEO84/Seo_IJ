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

    //get 방식 호출
    // URL 주소에서, 쿼리 스트링 형식으로
    //예시) http://localhost:8080/my?username="lsy&password="1234"
    // 데이터 표기를 함.
    // get 으로 호출한다면, 화면 조회를 할 때.
    // 글쓰기 폼, 로그인 폼, 회원가입 폼, 상세화면, 조회 화면.

    // post 방식 호출.
    // http 프로토콜. 통신 약속,
    // 헤더, 바디로 구성, 바디에 데이터를 담아서 서버에 전달.
    // get 은 길이 제한이 있음.
    // post 는 길이 제한이 없음. 바디에 데이터를 담아서, 전송.
    // 예시) insert , update , delete , 뭔가 데이터를 처리하는 경우,
    // 글쓰기, 수정, 삭제,

    // put, delete, patch, 여러가지 통신 메소드들이 있음.
    // REST ful 형식으로 할때, 응답 할 때, 화면 없이 데이터 만 전달.


    // 웹서버의 특징.
    // 비연결성.
    // 클 -> 서 , 요청, 서버는 얼른 응답 연결 끊기

    // 서버는 현재, 서버 사이드 렌더링.
    // 서버가
    // 1)화면도 그려주고,
    // 2) 또 데이터 도 전달 해줘요, 바쁘다, 바뻐.
    // 클라이언트 사이드 렌더링, - REST ful 형식. 서버는 단순 데이터만 전달.
    // 화면는 프론트 서버 너가 그려.

    // 리액트 서버, 백엔드 서버, 디비 서버, 미디어 서버 ,, 캐쉬 서버 .

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
