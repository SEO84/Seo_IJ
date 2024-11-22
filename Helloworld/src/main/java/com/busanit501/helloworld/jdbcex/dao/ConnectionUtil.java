package com.busanit501.helloworld.jdbcex.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public enum ConnectionUtil {
    INSTANCE;
    private HikariDataSource ds;

    ConnectionUtil() {
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

        ds = new HikariDataSource(hikariConfig);

    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
