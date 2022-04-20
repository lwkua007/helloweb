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
            Double price = resultSet.getDouble("price");
            Double rating = resultSet.getDouble("rating");
            Image image = new Image(imageId, name, category, price, rating);
            images.add(image);
        }
        return images;
    }


    public List<Image> findAll() throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("SELECT id imageId, name, category, rating, price " +
                        "FROM (SELECT * FROM image i " +
                        "LEFT OUTER JOIN " +
                        "(SELECT image_id,ROUND(AVG(rating),1)rating " +
                        "from rate GROUP BY image_id)r on i.id=r.image_id) image;");

        ResultSet resultSet = statement.executeQuery();

        List<Image> images = map(resultSet);
        return images;
    }

}
