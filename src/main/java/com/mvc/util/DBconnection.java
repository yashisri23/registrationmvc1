package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
    public static Connection createConnection() {
        Connection con = null;
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root&password=root@admin"; // Corrected URL
        String username = "root";
        String password = "root@admin";
        System.out.println("In DBconnection.java class ");

        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Updated Driver class name
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url);
            System.out.println("Printing connection object " + con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
