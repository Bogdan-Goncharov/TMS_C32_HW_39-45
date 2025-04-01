package com.hw.util;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor
@Component

public class DatabaseConnection {
    public static final String URL = "jdbc:postgresql://localhost:5432/db39-44";
    public static final String USERNAME = "user";
    public static final String PASSWORD = "0305";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
