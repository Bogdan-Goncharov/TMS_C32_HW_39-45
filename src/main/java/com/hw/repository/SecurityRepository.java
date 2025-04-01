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
@Repository
public class SecurityRepository {

    public List<Security> getAllSecurities() {
        List<Security> securities = new ArrayList<>();
        String query = "SELECT id, login, password, role, created, updated, user_id FROM security";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
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
        String query = "SELECT id, login, password, role, created, updated, user_id FROM security WHERE id = ?";
        Security security = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

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
        String query = "INSERT INTO security (login, password, role, created, updated, user_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

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
        String query = "DELETE FROM security WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Обработайте ошибки
        }
    }
}
