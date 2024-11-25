package com.busanit501.helloworld.jdbcex.dao;

import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

    //1 . insert
    // Todo 등록기능, 추가하기.
    // VO(Value Object, 실제 디비 컬럼과 일치함)
    // 서비스 계층에서, VO 넘겨 받은 데이터 중에서, 보여줄 데이터만 따로 분리해서,
    // 전달하는 용도로 사용하는 DTO 입니다.

    public void insert(TodoVO todoVO) throws SQLException {

        String sql = "insert into tbl_todo (title, dueDate, finished) " +
                "values (?, ?, ?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, todoVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(todoVO.getDueDate()));
        preparedStatement.setBoolean(3, todoVO.isFinished());
        preparedStatement.executeUpdate();
    } //insert

    //2
    // select , DB에서 전체 조회.
    public List<TodoVO> selectAll() throws SQLException {
        String sql = "select * from tbl_todo";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        // 넘어온 데이터를 임시로 보관할 리스트 인스턴스 만들고,
        // 반복문 통해서, 넘어온 각행을 리스트에 요소로 하나씩 담기.
        List<TodoVO> list = new ArrayList<>();
        while (resultSet.next()) {
            TodoVO todoVO = TodoVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .title(resultSet.getString("title"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();
            list.add(todoVO);
        }
        return list;
    }

    //3, 하나 조회. 상세보기.
    public TodoVO selectOne(Long tno) throws SQLException {
        String sql = "select * from tbl_todo where tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);
        // 하나만 받아온 상태,
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        // 임시 TotoVO , 인스턴스 만들어서, 한행의 각 컬럼 4개를 담기.
        // 0행에서 -> 1행으로 조회를 해야하는데, 요게 누락됨.
        resultSet.next();
        TodoVO todoVO = TodoVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();
        return todoVO;
    }

    // 수정.
    // update,
    //  화면에서 낱개로 넘어온 데이터는 DTO 담아서 전달,
    // 서비스 계층에서, DTO -> VO(Value Object) 데이터베이스 직접적인 연관있음.
    // 예시, VO 클래스는 , 테이블과 컬럼과 동일.
    // 예시2) ,DTO 화면( 출력에서 전달하고 싶은 데이터만 골라서 사용할수 있음. )
    // 화면에서 받아옴, 테스트 , 더미 데이터 확인.
    public void updateOne(TodoVO todoVO) throws SQLException {
        String sql = " update tbl_todo set title=?, dueDate=?, finished=?" +
                " where tno=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 화면에서 넘겨받은 변경할 데이터를 DTO -> VO 변환 후에(서비스에서 할 예정.)
        // VO 에서 꺼내서, 디비로 데이터 전달하는 과정.
        preparedStatement.setString(1, todoVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(todoVO.getDueDate()));
        preparedStatement.setBoolean(3,todoVO.isFinished());
        preparedStatement.setLong(4,todoVO.getTno());
        preparedStatement.executeUpdate();

    }

    //삭제,
    // delete,
    public void deleteTodo(Long tno) throws SQLException {
        String sql = "delete from tbl_todo where tno =?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);
        preparedStatement.executeUpdate();

    }



    /// /////////////////////////////////////////////////////////////////////////
    public String getTime() {
        String now = null;
        // hikariCP 이용해서,
        // 디비 연결하고,
        // sql 전달하고,
        // 결과값 받고,
        // 자원 반납
        // 자원 반납 하는 방법 2가지.
        //1)
        // try catch -> try with resource , 자동으로 자원 반납을 함.
        // autocloseable 인터페이스를 구현한 기능들만, 자동 반납.
        // 2) 애너테이션 이용해서, @cleanup , 이용하면, 간단히 자동 반납.
        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("select now()");
             ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            resultSet.next();
            now = resultSet.getString(1);

        } catch (Exception e) {
            e.printStackTrace();
        } //catch
        return now;
    } //getTime

    public String getTime2() throws SQLException {
        String now = null;
        // 자동으로 디비의 connection 반납하는 방법2
        // @Cleanup
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("select now()");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        now = resultSet.getString(1);
        return now;
    }


} //class

