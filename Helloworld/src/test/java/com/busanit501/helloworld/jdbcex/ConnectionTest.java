package com.busanit501.helloworld.jdbcex;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectionTest {

    @Test
    public void testConnection() throws Exception {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        hikariConfig.setUsername("webuser");
        hikariConfig.setPassword("webuser");
        // 캐쉬 기능이용해서, 메모리상에 임시 저장에서, 꺼내서 사용하겠다.
        // 얼마나 저장 할거냐? 250 길이로, 최대, 2048 까지 기억하겠다.

        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        Connection connection = hikariDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
