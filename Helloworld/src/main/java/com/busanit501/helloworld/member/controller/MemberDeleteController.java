package com.busanit501.helloworld.member.controller;

import com.busanit501.helloworld.member.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2 // log.info("이런 형식으로 출력 한다.")
@WebServlet(name = "MemberDeleteController", urlPatterns = "/member/delete")
public class MemberDeleteController extends HttpServlet {
    // Use the MemberService to handle member-related operations
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the member number (mno) from the request
        Long mno = Long.valueOf(request.getParameter("mno"));

        log.info("doPost MemberDeleteController 확인, mno: {}", mno);

        try {
            // Call the delete method from MemberService to delete the member
            memberService.delete(mno);
        } catch (SQLException e) {
            log.error("Error occurred while deleting member with mno {}", mno, e);
            throw new RuntimeException(e);
        }

        // After successful deletion, redirect to the member list page
        response.sendRedirect("/member/list");
    }
}
