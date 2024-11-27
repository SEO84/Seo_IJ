package com.busanit501.helloworld.food.dao;

import com.busanit501.helloworld.food.vo.FoodVO;
import com.busanit501.helloworld.jdbcex.dao.ConnectionUtil;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO {

    public void insert(FoodVO foodVO) throws SQLException {

        String sql = "insert into tbl_food (title, dueDate, finished) " +
                "values (?, ?, ?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, foodVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(foodVO.getDueDate()));
        preparedStatement.setBoolean(3, foodVO.isFinished());
        preparedStatement.executeUpdate();
    } //insert

    //2
    // select , DB에서 전체 조회.
    public List<FoodVO> selectAll() throws SQLException {
        String sql = "select * from tbl_food";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        // 넘어온 데이터를 임시로 보관할 리스트 인스턴스 만들고,
        // 반복문 통해서, 넘어온 각행을 리스트에 요소로 하나씩 담기.
        List<FoodVO> list = new ArrayList<>();
        while (resultSet.next()) {
            FoodVO foodVO = FoodVO.builder()
                    .fno(resultSet.getLong("fno"))
                    .title(resultSet.getString("title"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();
            list.add(foodVO);
        }
        return list;
    }



} //class

