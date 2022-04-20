package bsu.by.web.dao;


import bsu.by.web.entity.Image;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ImageDao {

    public Image findById(int id) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("select id, name, category from image where id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        List<Image> images = map(resultSet);
        return images.size() == 1 ? images.get(0) : null;
    }

    private List<Image> map(ResultSet resultSet) throws SQLException{
        List<Image> images = new ArrayList<>();
        while (resultSet.next()){
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String category = resultSet.getString("category");
            Double price = resultSet.getDouble("price");
            Double rating = resultSet.getDouble("rating");
            Image image = new Image(id, name, category, price, rating);
            images.add(image);
        }

        return images;
    }

    public List<Image> findAll() throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("select image.name,image.id,image.category,image.price," +
                        "ROUND(AVG(rate.rating),1) as rating from image,rate where image.id = rate.image_id;");
        ResultSet resultSet = statement.executeQuery();

        List<Image> images = map(resultSet);
        return images;
    }

//    public void save(Image image) throws SQLException{
//        ConnectionFactory factory = new ConnectionFactory();
//        Connection connection = factory.create();
//
//        PreparedStatement statement = connection.
//                prepareStatement("insert into image (name, category) values (?,?)");
//        statement.setString(1, image.getName());
//        statement.setString(2, image.getCategory());
//        statement.executeUpdate();
//
//    }

}
