package com.mvc.util.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.bean.Registerbean;

public class Registerdao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/users?useSSL=false&serverTimezone=UTC";

    
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin@root";
    private String jdbcDriver = "com.mysql.cj.jdbc.Driver";

    private static final String INSERT_USERS_SQL = "INSERT INTO user" + "  (id,fullname, email, password) VALUES "
            + " (?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,fullname,email,password from user where id =?";
    private static final String SELECT_ALL_USERS = "select * from user";
    private static final String DELETE_USERS_SQL = "delete from user where id = ?;";
    private static final String UPDATE_USERS_SQL = "update user set fullname = ?,email= ?, password =? where id = ?;";

    public Registerdao() {
    }

    protected Connection getConnection() { 
        Connection connection = null ;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(Registerbean user) throws SQLException {
    	System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Registerbean selectUser(int id) {
        Registerbean user = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
        	System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("fullname");
                String email = rs.getString("email");
                String password = rs.getString("password");

                user = new Registerbean(id, name, email, password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<Registerbean> selectAllUsers()  {
        List<Registerbean> user = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
        	System.out.println(preparedStatement);
        	ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("fullname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                user.add(new Registerbean(id, name, email, password));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user ;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(Registerbean user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            System.out.println("updated USer:"+statement);
        	statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4,  user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
