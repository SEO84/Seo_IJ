package com.busanit501.helloworld.member.controller;

import com.busanit501.helloworld.member.dto.MemberDTO;
import com.busanit501.helloworld.member.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(name = "MemberUpdateController", urlPatterns = "/member/update")
public class MemberUpdateController extends HttpServlet {
    // 서비스를 포함하기. 의존하기.
    private MemberService memberService = MemberService.INSTANCE;
    // 날짜 포맷팅
    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 화면 전달.
        // 서비스에서, 하나의 member 데이터를 조회 후,
        try {
            // 클릭한 멤버 번호를 가지고 와야함.
            Long mno = Long.parseLong(request.getParameter("mno"));
            MemberDTO memberDTO = memberService.get(mno);
            // 화면에 전달하기.
            request.setAttribute("dto", memberDTO);
            request.getRequestDispatcher("/WEB-INF/member/memberUpd.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 글 작성 로직 처리.
    // 화면에서 데이터 전달받고, -> DTO 담아서, -> 서비스로 전달.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // PRG 패턴,
        // POST 처리 후, Redirect , Get 호출,
        // 무한 post 방지 효과, 화면 전환 효과.
        // 임시로 담을 DTO 인스턴스 필요함.

        // 넘어온 값의 형태 : 문자열 : "on"
        String active = request.getParameter("active");
        log.info("active : " + active);
        boolean checkActive = false;
        if ("on".equals(active)) {
            checkActive = true;
        }
        MemberDTO memberDTO = MemberDTO.builder()
                .mno(Long.valueOf(request.getParameter("mno")))
                .name(request.getParameter("name"))
                .email(request.getParameter("email"))
                .birthDate(LocalDate.parse(request.getParameter("birthDate"), DATE_TIME_FORMATTER))
                .active(checkActive)
                .build();
        log.info("memberDTO 수정된 내용: " + memberDTO);
        // Controller -> Service
        try {
            memberService.update(memberDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/member/list");
    }
}
