package bsu.by.web.dao;


import bsu.by.web.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
    public User login(String email, String password)
            throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.prepareStatement
                ("select * from user where email = ? and password = MD5(?)");

        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            return new User(
                    resultSet.getInt("is_admin"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getInt("state"),
                    resultSet.getDouble("balance"),
                    0
            );
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


    public void addUser(User addUser) throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("insert into user " +
                        "(is_admin, email, password, state, balance) values (?, ?, ?, ?, ?)");
        statement.setInt(1, addUser.getIsAdmin());
        statement.setString(2, addUser.getEmail());
        statement.setString(3, addUser.getPassword());
        statement.setInt(4, addUser.getState());
        statement.setDouble(5, addUser.getBalance());
        statement.executeUpdate();
    }


    private List<User> map(ResultSet resultSet) throws SQLException{
        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            Integer is_admin = resultSet.getInt("is_admin");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            Integer state = resultSet.getInt("state");
            Double balance = resultSet.getDouble("balance");
            Integer image_count = resultSet.getInt("image_count");
            User user = new User(is_admin, email, password, state, balance, image_count);
            users.add(user);
        }
        return users;
    }

    public List<User> findAll() throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("select id, is_admin, email, password, state, balance, image_count " +
                        "from (select * from user u left outer join " +
                        "(select image.user_id,count(image.id)image_count from image group by image.user_id)c " +
                        "on u.id=c.user_id)user;");
        ResultSet resultSet = statement.executeQuery();

        List<User> user = map(resultSet);
        System.out.println(user);
        return user;
    }
}
