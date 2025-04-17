package com.hw.config;

public interface SQLQuery {
    String GET_ATTRIBUTES = "SELECT id, name, price, created, updated FROM product";
    String SET_PRODUCTS =  "INSERT INTO product (name, price, created, updated) VALUES (?, ?, ?, ?)";
    String DELETE_ID = "DELETE FROM product WHERE id = ?";
    String GET_FROM_SECURITY = "SELECT id, login, password, role, created, updated, user_id FROM security";
    String CHECK_SECURITY = "SELECT id, login, password, role, created, updated, user_id FROM security WHERE id = ?";
    String NEW_SECURITY_RECORD= "INSERT INTO security (login, password, role, created, updated, user_id) VALUES (?, ?, ?, ?, ?, ?)";
    String DELETE_SECURITY= "DELETE FROM security WHERE id = ?";
    String GET_USERS = "SELECT * FROM users";
    String GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?";



}
