package com.busanit501.helloworld;

import com.busanit501.helloworld.member.dto.MemberDTO;
import com.busanit501.helloworld.member.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Log4j2
public class MemberServiceTest {
    private MemberService memberService;

    @BeforeEach
    public void ready() {
        memberService = MemberService.INSTANCE;
    }

    // 등록
    @Test
    public void testInsert() throws SQLException {
        // 더미 데이터, 화면에서 전달 받은 MemberDTO
        MemberDTO memberDTO = MemberDTO.builder()
                .name("서현우")
                .email("seo@example.com")
                .birthDate(LocalDate.now())
                .build();
        memberService.register(memberDTO);
    }

    // 전체 조회
    @Test
    public void testSelectAll() throws SQLException {
        List<MemberDTO> dtoList = memberService.listAll();
        for (MemberDTO memberDTO : dtoList) {
            log.info(memberDTO);
        }
    }

    // 하나 조회, 상세보기
    @Test
    public void testSelectOne() throws SQLException {
        MemberDTO memberDTO = memberService.get(9L);
        log.info("하나 조회. memberDTO " + memberDTO);
    }

    // 하나 수정
    @Test
    public void testUpdateOne() throws SQLException {
        MemberDTO memberDTO = MemberDTO.builder()
                .mno(3L)
                .name("김기백")
                .email("kibak@example.com")
                .birthDate(LocalDate.now())
                .build();
        memberService.update(memberDTO);
    }

    // 하나 삭제
    @Test
    public void testDeleteOne() throws SQLException {
        memberService.delete(3L);
    }
}
