package com.busanit501.helloworld.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectTest {
    // 기본 단위테스트 동작 여부
    @Test
    public void test() {
        int v1 = 100;
        int v2 = 100;
        Assertions.assertEquals(v1, v2);
    }
    // 디비 연결 확인 테스트,
    @Test
    public void test2() throws ClassNotFoundException, SQLException {
        // 마리아 디비 드라이버, 메모리상에 로드,
        Class.forName("org.mariadb.jdbc.Driver");

        // Connection 인터페이스 이용해서, 디비 서버에 접근하는 준비물 준비.
         Connection con = DriverManager.getConnection
                 ("jdbc:mariadb://localhost:3306/webdb", "webuser", "webuser");
         // 해당 인스턴스가 존재 하는지 유무 확인
        Assertions.assertNotNull(con);

        // 자원 반납
        con.close();
    }

}
