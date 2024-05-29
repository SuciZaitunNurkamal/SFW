package id.project.sfw.confiq;

import java.sql.*;

public class DbConnect {
    private static final String DB_URL = "jdbc:sqlite:db/db_user.db";
    
    public static void insertData(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
        Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)";
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            
            System.out.println("Data inserted successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static boolean checkUsername(String username) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
        Statement stmt = conn.createStatement()) {
            String sql = "SELECT username,password FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }


    public static boolean ValidasiLogin(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
        Statement stmt = conn.createStatement()) {
            String sql = "SELECT username,password FROM users WHERE username = ? AND password = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
           
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }


    public static boolean validatePassword(String password) {
        if (password.length() < 3 || password.length() > 15 || password.contains(" ")) {
            return false;
        }
        else{
            boolean hasDigit = false;
            boolean hasLetter = false;
            boolean hasUppercase = false;

            for (char c : password.toCharArray()) {
                if (Character.isDigit(c)) {
                    hasDigit = true;
                } else if (Character.isLetter(c)) {
                    hasLetter = true;
                    if (Character.isUpperCase(c)) {
                        hasUppercase = true;
                    }
                }
            }
            return hasDigit && hasLetter && hasUppercase;
        }
    }


}





