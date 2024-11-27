package com.busanit501.helloworld.jdbcex.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//톰캣 서버에서,
// 한글로 입력된 내용을, UTF8로 변환해서 보내기.
// 필터, 서버에 작업을 실행하기전에, 먼저 검사한다.
// 유효성 체크.
@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter ,/todo/* 하위로 들어오는 모든 url 에 대해서 로그인 체크함");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 세션 정보를 호출 및 가져오기.
        HttpSession session = request.getSession();

        // 만약에, 서버에서 최초로 접근했다면,
        // 서버에서, JSESSIONID 발급을 해준다.
        if(session.isNew()) {
            log.info("최초로 서버에 요청을함.");
            // 로그인 컨트롤러가 아직 없음, 곧 만들 예정.
            response.sendRedirect("/login");
            return;
        }
        // 2번째 이후의 방문, 하지만, 세션이라는 저장공간,
        // 여기에 키 : loginInfo , 값: 로그인한 유저의 아이디를 기록.
        if(session.getAttribute("loginInfo") == null) {
            log.info("2번째 이후로 서버에 요청을했고, 하지만, 로그인 정보는 없는 경우.");
            // 로그인 컨트롤러가 아직 없음, 곧 만들 예정.
            response.sendRedirect("/login");
            return;
        }
        //임시로, 최초도 아니고, 로그인 처리가 되었다면, 그러면,
        // 정상적으로 접근하는 페이지로 이동 시켜 줄게.
        if(session.getAttribute("loginInfo") != null) {
            String result  = (String) session.getAttribute("loginInfo");
            log.info("session.getAttribute(\"loginInfo\") result : " + result);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
