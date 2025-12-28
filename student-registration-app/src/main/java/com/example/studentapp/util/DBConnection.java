package com.example.studentapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Database connection configuration for XAMPP
    // Default XAMPP MySQL settings:
    //   - host: localhost
    //   - port: 3306
    //   - username: root
    //   - password: empty (no password)
    //   - database: student_db (make sure this database exists in phpMyAdmin)

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/student_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "";  // Empty password for root in XAMPP

    public static Connection getConnection() {
        try {
            // Load the MySQL JDBC driver (modern versions don't strictly need this, but it's safe)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found. Add mysql-connector-j-*.jar to your project's classpath.", e);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to database. Check:\n" +
                    "1. XAMPP MySQL is running (start Apache & MySQL in XAMPP Control Panel)\n" +
                    "2. Database 'student_db' exists in phpMyAdmin\n" +
                    "3. No password is set for root user\n" +
                    "4. JDBC URL and credentials are correct.", e);
        }
    }
}