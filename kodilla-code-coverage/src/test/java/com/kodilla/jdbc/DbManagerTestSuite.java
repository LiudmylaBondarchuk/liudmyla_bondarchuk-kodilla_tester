package com.kodilla.jdbc;

import org.junit.jupiter.api.*;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.*;
import java.util.AbstractMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@DisplayName("DbManager Tests")
class DbManagerTestSuite {

    @Container
    private static final MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("kodilla_tester")
            .withUsername("test")
            .withPassword("test")
            .withInitScript("schema.sql");

    private static DbManager dbManager;

    @BeforeAll
    static void setup() throws SQLException {
        System.setProperty("db.url", mysql.getJdbcUrl());
        System.setProperty("db.user", mysql.getUsername());
        System.setProperty("db.password", mysql.getPassword());
        dbManager = DbManager.getInstance();
    }

    @Test
    @DisplayName("should connect to database")
    void testConnect() {
        assertNotNull(dbManager.getConnection());
    }

    @Test
    @DisplayName("should select users after insert")
    void testSelectUsers() throws SQLException {
        //Given
        String countQuery = "SELECT COUNT(*) FROM USERS";
        int count;
        try (Statement statement = createStatement();
             ResultSet rs = statement.executeQuery(countQuery)) {
            count = getRowsCount(rs);
        }
        insertUsers();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        int counter;
        try (Statement statement = createStatement();
             ResultSet rs = statement.executeQuery(sqlQuery)) {
            //Then
            counter = getResultsCount(rs);
        }
        int expected = count + 5;
        assertEquals(expected, counter);
    }

    @Test
    @DisplayName("should find users with multiple posts")
    void testSelectUsersAndPosts() throws SQLException {
        //Given
        String countQuery = "SELECT COUNT(*) FROM ("
                + "SELECT U.FIRSTNAME, U.LASTNAME "
                + "FROM USERS U "
                + "JOIN POSTS P ON U.ID = P.USER_ID "
                + "GROUP BY U.ID, U.FIRSTNAME, U.LASTNAME "
                + "HAVING COUNT(*) >= 2"
                + ") AS SUBQUERY";
        int initialCount;
        try (Statement statement = createStatement();
             ResultSet rs = statement.executeQuery(countQuery)) {
            initialCount = getRowsCount(rs);
        }

        // Insert a user with 2 posts to ensure at least one result
        int userId;
        try (Statement statement = createStatement()) {
            statement.executeUpdate(
                    "INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('TestJDBC', 'User')");
            try (ResultSet rs = statement.executeQuery("SELECT LAST_INSERT_ID()")) {
                rs.next();
                userId = rs.getInt(1);
            }
            statement.executeUpdate(
                    "INSERT INTO POSTS(USER_ID, BODY) VALUES ("
                            + userId + ", 'Post one')");
            statement.executeUpdate(
                    "INSERT INTO POSTS(USER_ID, BODY) VALUES ("
                            + userId + ", 'Post two')");
        }

        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POST_COUNT "
                + "FROM USERS U "
                + "JOIN POSTS P ON U.ID = P.USER_ID "
                + "GROUP BY U.ID, U.FIRSTNAME, U.LASTNAME "
                + "HAVING COUNT(*) >= 2";
        int counter;
        try (Statement statement = createStatement();
             ResultSet rs = statement.executeQuery(sqlQuery)) {
            //Then
            counter = 0;
            while (rs.next()) {
                System.out.printf("%s %s - posts: %d%n",
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getInt("POST_COUNT"));
                counter++;
            }
        }
        assertEquals(initialCount + 1, counter);
    }

    private Statement createStatement() throws SQLException {
        return dbManager.getConnection().createStatement();
    }

    private static final List<AbstractMap.SimpleEntry<String, String>> USERS = List.of(
            new AbstractMap.SimpleEntry<>("Zara", "Ali"),
            new AbstractMap.SimpleEntry<>("Otman", "Use"),
            new AbstractMap.SimpleEntry<>("Mark", "Boq"),
            new AbstractMap.SimpleEntry<>("Uli", "Wimer"),
            new AbstractMap.SimpleEntry<>("Oli", "Kosiw")
    );

    private void insertUsers() throws SQLException {
        String sql = "INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES (?, ?)";
        try (PreparedStatement pstmt = dbManager.getConnection().prepareStatement(sql)) {
            for (AbstractMap.SimpleEntry<String, String> user : USERS) {
                pstmt.setString(1, user.getKey());
                pstmt.setString(2, user.getValue());
                pstmt.executeUpdate();
            }
        }
    }

    private static int getResultsCount(ResultSet rs) throws SQLException {
        int counter = 0;
        while (rs.next()) {
            System.out.printf("%d, %s, %s%n",
                    rs.getInt("ID"),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"));
            counter++;
        }
        return counter;
    }

    private static int getRowsCount(ResultSet rs) throws SQLException {
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }
}
