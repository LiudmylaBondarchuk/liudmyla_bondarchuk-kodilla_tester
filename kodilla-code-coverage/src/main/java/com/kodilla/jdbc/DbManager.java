package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {

    private final Connection conn;
    private static DbManager dbManagerInstance;

    private DbManager() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", System.getProperty("db.user", "kodilla"));
        connectionProps.put("password", System.getProperty("db.password", "kodilla"));
        String url = System.getProperty("db.url",
                "jdbc:mysql://localhost:3306/kodilla_tester?serverTimezone=Europe/Warsaw&useSSL=False");
        conn = DriverManager.getConnection(url, connectionProps);
    }

    public static synchronized DbManager getInstance() throws SQLException {
        if (dbManagerInstance == null) {
            dbManagerInstance = new DbManager();
        }
        return dbManagerInstance;
    }

    public Connection getConnection() {
        return conn;
    }
}
