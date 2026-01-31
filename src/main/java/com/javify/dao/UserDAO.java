package com.javify.dao;

import com.javify.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public boolean validate(String username, String password) {
    String query = "SELECT * FROM users WHERE username = ? AND password = ?";
    
    // 1. Get connection outside the try-block so we can check if it failed
    Connection conn = DatabaseConnection.getConnection();
    
    if (conn == null) {
        System.out.println("❌ Database connection failed. Check your password!");
        return false; // Return false immediately so app doesn't crash
    }

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    } finally {
        // Close connection manually since we opened it outside the try-block
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
}
}