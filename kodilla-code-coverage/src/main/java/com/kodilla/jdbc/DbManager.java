package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager implements AutoCloseable {

    private static final String DEFAULT_USER = "kodilla";
    private static final String DEFAULT_PASSWORD = "kodilla";
    private static final String DEFAULT_URL =
            "jdbc:mysql://localhost:3306/kodilla_tester"
                    + "?serverTimezone=Europe/Warsaw&useSSL=False";

    private final Connection conn;
    private static volatile DbManager dbManagerInstance;

    private DbManager() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user",
                System.getProperty("db.user", DEFAULT_USER));
        connectionProps.put("password",
                System.getProperty("db.password", DEFAULT_PASSWORD));
        String url = System.getProperty("db.url", DEFAULT_URL);
        conn = DriverManager.getConnection(url, connectionProps);
    }

    public static DbManager getInstance() throws SQLException {
        DbManager instance = dbManagerInstance;
        if (instance == null) {
            synchronized (DbManager.class) {
                instance = dbManagerInstance;
                if (instance == null) {
                    instance = new DbManager();
                    dbManagerInstance = instance;
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }

    @Override
    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
        synchronized (DbManager.class) {
            if (dbManagerInstance == this) {
                dbManagerInstance = null;
            }
        }
    }
}
