package bsu.by.web.dao;


import bsu.by.web.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao {


    public User login(String email, String password) throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.prepareStatement
                ("select * from user where email = ? and password = MD5(?)");

        statement.setString(1, email);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            return new User(0,
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
            Integer userId = resultSet.getInt("userId");
            Integer is_admin = resultSet.getInt("is_admin");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            Integer state = resultSet.getInt("state");
            Double balance = resultSet.getDouble("balance");
            Integer image_count = resultSet.getInt("image_count");

            User user = new User(userId, is_admin, email, password, state, balance, image_count);
            users.add(user);
        }
        return users;
    }

    public List<User> findAll() throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("select id userId, is_admin, email, password, state, balance, image_count " +
                        "from (select * from user u left outer join " +
                        "(select image.user_id,count(image.id)image_count from image group by image.user_id)c " +
                        "on u.id=c.user_id)user;");

        ResultSet resultSet = statement.executeQuery();

        List<User> users = map(resultSet);

        return users;
    }

    public void deleteUser(Integer userId) throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("delete u.*,i.*,il.* from user u " +
                        "LEFT JOIN image i on u.id=i.user_id " +
                        "LEFT JOIN image_location il on u.id=il.user_id " +
                        "where u.id=?;");

        statement.setInt(1, userId);

        statement.executeUpdate();
    }

    private List<User> mapFindByUserId(ResultSet resultSet) throws SQLException{
        List<User> users = new ArrayList<>();

        while (resultSet.next()){
            Integer userId = resultSet.getInt("userId");
            Integer isAdmin = resultSet.getInt("isAdmin");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            Integer state = resultSet.getInt("state");
            Double balance = resultSet.getDouble("balance");

            User user = new User(userId, isAdmin, email, password, state, balance,0);
            users.add(user);
        }
        return users;
    }

    public User findByUserId(Integer userId) throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("SELECT id userId,is_admin isAdmin,email,password,state,balance " +
                        "from user WHERE id=?;");

        statement.setInt(1, userId);

        ResultSet resultSet = statement.executeQuery();
        List<User> users = mapFindByUserId(resultSet);

        return users.size()==1 ? users.get(0):null;
    }

    public void updateUserInfo(User user)
            throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("update user set is_admin = ?,email =?,password =?,state =?,balance=? where id =?;");

        statement.setInt(1, user.getIsAdmin());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());
        statement.setInt(4, user.getState());
        statement.setDouble(5, user.getBalance());
        statement.setInt(6, user.getUserId());

        statement.executeUpdate();
    }
}
