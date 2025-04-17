package com.hw.repository;

import com.hw.model.dto.Security;
import com.hw.util.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.hw.config.SQLQuery.*;

@Repository
public class SecurityRepository {

    public List<Security> getAllSecurities() {
        List<Security> securities = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_FROM_SECURITY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Security security = new Security();
                security.setId(resultSet.getLong("id"));
                security.setLogin(resultSet.getString("login"));
                security.setPassword(resultSet.getString("password"));
                security.setRole(resultSet.getString("role"));
                security.setCreated(resultSet.getTimestamp("created"));
                security.setUpdated(resultSet.getTimestamp("updated"));
                security.setUserId(resultSet.getLong("user_id"));

                securities.add(security);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Обработайте ошибки
        }

        return securities;
    }

    public Security getSecurityById(Long id) {
        Security security = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(CHECK_SECURITY)) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    security = new Security();
                    security.setId(resultSet.getLong("id"));
                    security.setLogin(resultSet.getString("login"));
                    security.setPassword(resultSet.getString("password"));
                    security.setRole(resultSet.getString("role"));
                    security.setCreated(resultSet.getTimestamp("created"));
                    security.setUpdated(resultSet.getTimestamp("updated"));
                    security.setUserId(resultSet.getLong("user_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Обработайте ошибки
        }

        return security;
    }

    public void saveSecurity(Security security) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(NEW_SECURITY_RECORD)) {

            statement.setString(1, security.getLogin());
            statement.setString(2, security.getPassword());
            statement.setString(3, security.getRole());
            statement.setTimestamp(4, security.getCreated());
            statement.setTimestamp(5, security.getUpdated());
            statement.setLong(6, security.getUserId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Обработайте ошибки
        }
    }

    public void deleteSecurity(Long id) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SECURITY)) {

            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Обработайте ошибки
        }
    }
}
