package com.hw.repository;



import com.hw.model.dto.User;
import com.hw.util.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.hw.util.DatabaseConnection.*;
@Repository
public class UserRepository {
    public User getUserById(Long id) {
        String query = "SELECT * FROM users WHERE id = ?";
        User user = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setFirstname(resultSet.getString("firstname"));
                    user.setSecondName(resultSet.getString("second_name"));
                    user.setAge(resultSet.getInt("age"));
                    user.setEmail(resultSet.getString("email"));
                    user.setCreated(resultSet.getTimestamp("created"));
                    user.setUpdated(resultSet.getTimestamp("updated"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void saveUser(User user) {
        String query = "INSERT INTO users (firstname, second_name, age, email, created, updated) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, user.getFirstname());
            statement.setString(2, user.getSecondName());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getEmail());
            statement.setTimestamp(5, user.getCreated());
            statement.setTimestamp(6, user.getUpdated());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Обработайте ошибку
        }
    }
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users"; // Имя таблицы: users

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFirstname(resultSet.getString("firstname"));
                user.setSecondName(resultSet.getString("second_name"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setSex(resultSet.getString("sex"));
                user.setTelephoneNumber(resultSet.getString("telephone_number"));
                user.setCreated(resultSet.getTimestamp("created"));
                user.setUpdated(resultSet.getTimestamp("updated"));
                user.setDeleted(resultSet.getBoolean("is_deleted"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }


    }

