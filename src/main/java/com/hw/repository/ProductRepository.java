package com.hw.repository;

import com.hw.util.DatabaseConnection;
import com.hw.model.dto.Product;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.hw.config.SQLQuery.*;


@Repository
public class ProductRepository {
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ATTRIBUTES);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setCreate(resultSet.getTimestamp("created"));
                product.setUpdate(resultSet.getTimestamp("updated"));

                products.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public void saveProduct(Product product) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SET_PRODUCTS)) {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setTimestamp(3, product.getCreate());
            statement.setTimestamp(4, product.getUpdate());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Обработайте ошибку
        }
    }

    public void deleteProduct(int id) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ID)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Обработайте ошибку
        }
    }
}
