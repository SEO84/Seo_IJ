package com.busanit501.helloworld.member.controller;

import com.busanit501.helloworld.member.dto.MemberDTO;
import com.busanit501.helloworld.member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "MemberRegController", urlPatterns = "/member/register")
public class MemberRegController extends HttpServlet {

    // 서비스 의존성 주입
    private MemberService memberService = MemberService.INSTANCE;
    // 날짜 포맷팅
    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 회원 등록 화면으로 이동
        request.getRequestDispatcher("/WEB-INF/member/memberReg.jsp")
                .forward(request, response);
    }

    // 회원 등록 처리 로직
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // PRG 패턴 사용 (POST 후 GET 호출)
        // 폼에서 받은 데이터를 MemberDTO에 담고 서비스로 전달
        MemberDTO memberDTO = MemberDTO.builder()
                .name(request.getParameter("name"))
                .email(request.getParameter("email"))
                .birthDate(LocalDate.parse(request.getParameter("birthDate"), DATE_TIME_FORMATTER))
                .active(true) // 기본적으로 활성화된 상태로 설정
                .build();

        try {
            // MemberService로 회원 등록 요청
            memberService.register(memberDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("doPost : 회원 등록 처리 후, 목록으로 이동");
        // 등록 후 회원 목록 페이지로 리디렉션
        response.sendRedirect("/member/list");
    }
}
