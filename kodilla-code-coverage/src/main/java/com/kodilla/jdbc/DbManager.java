package com.kodilla.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DbManager implements AutoCloseable {

    private static final String PROPERTIES_FILE = "db.properties";
    private static final Pattern ENV_VAR_PATTERN = Pattern.compile("^\\$\\{([^:}]+)(?::(.*))?}$");

    private final Connection conn;
    private static volatile DbManager dbManagerInstance;

    private DbManager() throws SQLException {
        Properties fileProps = loadProperties();

        Properties connectionProps = new Properties();
        connectionProps.put("user",
                System.getProperty("db.user",
                        resolveProperty(fileProps.getProperty("db.user", "kodilla"))));
        connectionProps.put("password",
                System.getProperty("db.password",
                        resolveProperty(fileProps.getProperty("db.password", ""))));
        String url = System.getProperty("db.url",
                resolveProperty(fileProps.getProperty("db.url",
                        "jdbc:mysql://localhost:3306/kodilla_course"
                                + "?serverTimezone=Europe/Warsaw&useSSL=False")));
        conn = DriverManager.getConnection(url, connectionProps);
    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream in = DbManager.class.getClassLoader()
                .getResourceAsStream(PROPERTIES_FILE)) {
            if (in != null) {
                props.load(in);
            }
        } catch (IOException e) {
            // fallback to hardcoded defaults
        }
        return props;
    }

    static String resolveProperty(String value) {
        if (value == null) {
            return null;
        }
        Matcher matcher = ENV_VAR_PATTERN.matcher(value);
        if (!matcher.matches()) {
            return value;
        }
        String envVar = matcher.group(1);
        String defaultValue = matcher.group(2) != null ? matcher.group(2) : "";
        String envValue = System.getenv(envVar);
        return envValue != null ? envValue : defaultValue;
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

    // SpotBugs EI_EXPOSE_REP: shared connection by design (singleton connection manager)
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
