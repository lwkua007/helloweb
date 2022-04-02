package bsu.by.web.dao;


import bsu.by.web.entity.User;

import java.sql.*;


public class UserDao {
    public boolean login(String login, String password)
            throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/share_photo",
                        "root",
                        "lwkua4561230");

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.prepareStatement
                ("select name,password,is_admin from user where name = ? and password = MD5(?)");

        statement.setString(1,login);
        statement.setString(2,password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            return new User(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getBoolean("is_admin"));
        }


        return resultSet.next();
    }
}
