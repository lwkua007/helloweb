package bsu.by.web.dao;


import bsu.by.web.entity.User;

import java.sql.*;


public class UserDao {
    public User login(String login, String password)
            throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.prepareStatement
                ("select id, email, is_admin from user where email = ? and password = MD5(?)");

        statement.setString(1,login);
        statement.setString(2,password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            return new User(resultSet.getInt("id"),
                    resultSet.getString("email"),
                    resultSet.getBoolean("is_admin"));
        }

        return null;
    }
}
