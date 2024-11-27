package com.busanit501.helloworld.member.service;

import com.busanit501.helloworld.member.dao.MemberDAO;
import com.busanit501.helloworld.member.dto.MemberDTO;
import com.busanit501.helloworld.member.util.MapperUtil;
import com.busanit501.helloworld.member.vo.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {
    INSTANCE;

    private final MemberDAO memberDAO;
    private final ModelMapper modelMapper;

    // Constructor to initialize DAO and ModelMapper
    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // 1. Register a new member
    public void register(MemberDTO memberDTO) throws SQLException {
        // Convert DTO to VO using ModelMapper
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        log.info("Registering member: " + memberVO);

        // Call the DAO to insert the member
        memberDAO.insert(memberVO);
    }

    // 2. Get all members
    public List<MemberDTO> listAll() throws SQLException {
        // Fetch the list of VO objects from DAO
        List<MemberVO> voList = memberDAO.selectAll();
        log.info("Fetched member VO list: " + voList);

        // Convert the list of VO objects to DTOs
        List<MemberDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    // 3. Get details of a single member by mno
    public MemberDTO get(Long mno) throws SQLException {
        log.info("Fetching member with mno: " + mno);
        // Get the member VO from DAO
        MemberVO memberVO = memberDAO.selectOne(mno);

        // Convert VO to DTO
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        return memberDTO;
    }

    // 4. Update an existing member
    public void update(MemberDTO memberDTO) throws SQLException {
        log.info("Updating member: " + memberDTO);

        // Convert DTO to VO for database operation
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        // Call DAO to update the member
        memberDAO.updateOne(memberVO);
    }

    // 5. Delete a member
    public void delete(Long mno) throws SQLException {
        log.info("Deleting member with mno: " + mno);
        // Call DAO to delete the member
        memberDAO.deleteMember(mno);
    }
}
