package com.busanit501.helloworld.member.dao;

import com.busanit501.helloworld.member.vo.MemberVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    //1. insert
    public void insert(MemberVO memberVO) throws SQLException {
        String sql = "insert into tbl_member (name, email, birthDate, active) " +
                "values (?, ?, ?, ?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, memberVO.getName());
        preparedStatement.setString(2, memberVO.getEmail());
        preparedStatement.setDate(3, Date.valueOf(memberVO.getBirthDate()));
        preparedStatement.setBoolean(4, memberVO.isActive());
        preparedStatement.executeUpdate();
    } //insert

    //2. selectAll
    public List<MemberVO> selectAll() throws SQLException {
        String sql = "select * from tbl_member";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<MemberVO> list = new ArrayList<>();
        while (resultSet.next()) {
            MemberVO memberVO = MemberVO.builder()
                    .mno(resultSet.getLong("mno"))
                    .name(resultSet.getString("name"))
                    .email(resultSet.getString("email"))
                    .birthDate(resultSet.getDate("birthDate").toLocalDate())
                    .active(resultSet.getBoolean("active"))
                    .build();
            list.add(memberVO);
        }
        return list;
    }

    //3. selectOne
    public MemberVO selectOne(Long mno) throws SQLException {
        String sql = "select * from tbl_member where mno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, mno);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();  // move to the first row
        MemberVO memberVO = MemberVO.builder()
                .mno(resultSet.getLong("mno"))
                .name(resultSet.getString("name"))
                .email(resultSet.getString("email"))
                .birthDate(resultSet.getDate("birthDate").toLocalDate())
                .active(resultSet.getBoolean("active"))
                .build();
        return memberVO;
    }

    //4. updateOne
    public void updateOne(MemberVO memberVO) throws SQLException {
        String sql = "update tbl_member set name=?, email=?, birthDate=?, active=? where mno=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, memberVO.getName());
        preparedStatement.setString(2, memberVO.getEmail());
        preparedStatement.setDate(3, Date.valueOf(memberVO.getBirthDate()));
        preparedStatement.setBoolean(4, memberVO.isActive());
        preparedStatement.setLong(5, memberVO.getMno());
        preparedStatement.executeUpdate();
    }

    //5. delete
    public void deleteMember(Long mno) throws SQLException {
        String sql = "delete from tbl_member where mno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, mno);
        preparedStatement.executeUpdate();
    }
}
