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
import java.util.List;

@Log4j2 // log.info("이런 형식으로 출력 한다.")
@WebServlet(name = "MemberListController", urlPatterns = "/member/list")
public class MemberListController extends HttpServlet {
    // Use MemberService to manage members
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doGet MemberListController 확인");

        try {
            // Fetch the list of members from the service
            List<MemberDTO> memberList = memberService.listAll();
            // Set the list of members as a request attribute
            request.setAttribute("list", memberList);
            // Forward the request to the JSP for rendering
            request.getRequestDispatcher("/WEB-INF/member/memberList.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            log.error("Error occurred while fetching member list", e);
            throw new RuntimeException(e);
        }
    }
}
