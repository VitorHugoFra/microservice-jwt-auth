package com.example.service;

import com.example.domain.User;
import com.example.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    public User authenticate(String username, String password) {
        LOGGER.info("Authenticating user: " + username);
        User user = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
                        LOGGER.info("User authenticated successfully: " + username);
                    } else {
                        LOGGER.warning("Authentication failed for user: " + username);
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.severe("Database connection error: " + e.getMessage());
        }
        return user;
    }
}
