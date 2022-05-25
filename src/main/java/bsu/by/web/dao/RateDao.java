package bsu.by.web.dao;

import bsu.by.web.entity.Rate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RateDao {
    public void rate(Rate rate) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("insert into rate (rating, image_id , user_id) values (?, ?, ?);");

        statement.setDouble(1, rate.getRating());
        statement.setInt(2, rate.getImageId());
        statement.setInt(3, rate.getUserId());

        statement.executeUpdate();
    }

    public Rate findRateById(Integer imageId, Integer userId) throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("select rating from rate where image_id=? and user_id=?;");

        statement.setInt(1, imageId);
        statement.setInt(2, userId);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            return new Rate(
                    resultSet.getDouble("rating"));
        }

        return null;
    }

    public void updateRate(Rate rate) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("update rate set rating=? where image_id=? and user_id=?;");

        statement.setDouble(1, rate.getRating());
        statement.setInt(2, rate.getImageId());
        statement.setInt(3, rate.getUserId());

        statement.executeUpdate();
    }
}
