package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
public class MySql {
    private static Connection conn = null;

    public static Connection getConnection(){
        final String driver = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/prodcutmanagement";
        final String USER = "root";
        final String PASS = "1234567";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Connection conn1 = conn;
        return conn1;
    }
}
