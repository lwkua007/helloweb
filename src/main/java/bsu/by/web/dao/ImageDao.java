package bsu.by.web.dao;


import bsu.by.web.entity.Image;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ImageDao {


    private List<Image> map(ResultSet resultSet) throws SQLException{
        List<Image> images = new ArrayList<>();
        while (resultSet.next()){
            Integer imageId = resultSet.getInt("imageId");
            String name = resultSet.getString("name");
            String category = resultSet.getString("category");
            String price = resultSet.getString("price");
            Double rating = resultSet.getDouble("rating");
            String location = resultSet.getString("location");
            Image image = new Image(imageId, name, category, price, rating, location);
            images.add(image);
        }
        return images;
    }


    public List<Image> findAll() throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("SELECT id imageId, name, location, category, rating, price " +
                        "FROM (SELECT * FROM image i " +
                        "LEFT OUTER JOIN " +
                        "(SELECT image_id,ROUND(AVG(rating),1)rating " +
                        "from rate GROUP BY image_id)r on i.id=r.image_id) image;");

        ResultSet resultSet = statement.executeQuery();

        List<Image> images = map(resultSet);
        return images;
    }


    public void uploadImageInfo(Image uploadImageInfo) throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("INSERT INTO image (name, category, price, user_id, location) VALUES (?, ?, ?, ?, ?);");

        statement.setString(1, uploadImageInfo.getName());
        statement.setString(2, uploadImageInfo.getCategory());
        statement.setString(3, uploadImageInfo.getPrice());
        statement.setInt(4, uploadImageInfo.getUserId());
        statement.setString(5,uploadImageInfo.getLocation());

        statement.executeUpdate();
    }

    public void deleteImage(Integer imageId) throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("delete from image where id=?;");

        statement.setInt(1, imageId);

        statement.executeUpdate();
    }

    public List<Image> findByUserId(Integer userId) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("SELECT id imageId, name, location, category, rating, price " +
                        "FROM (SELECT * FROM image i " +
                        "LEFT OUTER JOIN " +
                        "(SELECT image_id,ROUND(AVG(rating),1)rating " +
                        "from rate GROUP BY image_id)r on i.id=r.image_id) image " +
                        "where user_id = ?;");

        statement.setInt(1, userId);

        ResultSet resultSet = statement.executeQuery();
        List<Image> images = map(resultSet);
        return images;
    }

    public List<Image> findByImageName(String name) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("SELECT id imageId, name, location, category, rating, price " +
                        "FROM (" +
                        "SELECT * FROM image i " +
                        "LEFT OUTER JOIN " +
                        "(SELECT image_id,ROUND(AVG(rating),1)rating " +
                        "from rate GROUP BY image_id)r on i.id=r.image_id) image " +
                        "where name like ?;");

        statement.setString(1, name);

        ResultSet resultSet = statement.executeQuery();
        List<Image> images = map(resultSet);
        return images;
    }
}
