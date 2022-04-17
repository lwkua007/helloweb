package bsu.by.web.dao;


import bsu.by.web.entity.User;

import java.sql.*;


public class UserDao {
    public User login(String email, String password)
            throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.prepareStatement
                ("select is_admin, email, password from user where email = ? and password = MD5(?)");

        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            return new User(
                    resultSet.getInt("is_admin"),
                    resultSet.getString("email"),
                    resultSet.getString("password"));
        }
        return null;
    }

    public void signUp(User signup) throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("INSERT INTO user " +
                        "(is_admin, email, password, state, balance) VALUES (0, ?, ?, 1, 0)");
        statement.setString(1, signup.getEmail());
        statement.setString(2, signup.getPassword());
        statement.executeUpdate();
    }

    public void create(User create) throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("insert into user " +
                        "(email, password, is_admin, state, balance) values (?, ?, ?, 1, 0)");
        statement.setString(1, create.getEmail());
        statement.setString(2, create.getPassword());
        statement.setInt(3, create.getIsAdmin());
        statement.executeUpdate();

    }
}
