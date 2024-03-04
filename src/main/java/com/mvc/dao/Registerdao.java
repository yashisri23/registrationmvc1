package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mvc.bean.Registerbean;
import com.mvc.util.DBconnection;

public class Registerdao {
    public String registerUser(Registerbean registerBean) {
        String fullName = registerBean.getFullName();
        String email = registerBean.getEmail();
        String password = registerBean.getPassword();

        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DBconnection.createConnection();
            String query = "insert into users(fullName, Email, password) values (?, ?, ?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int i = preparedStatement.executeUpdate();

            if (i != 0)
                return "SUCCESS";
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "Oops.. Something went wrong there..!";
    }

    public String email(Registerbean registerBean) {
        return null;
    }
}
