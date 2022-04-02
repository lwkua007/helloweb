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
            Image image = new Image(id, name, category);
            images.add(image);
        }

        return images;
    }

    public List<Image> findAll() throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("select id, name, category from image");
        ResultSet resultSet = statement.executeQuery();

        List<Image> images = map(resultSet);
        return images;
    }

    public void save(Image image) throws SQLException, ClassNotFoundException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();

        PreparedStatement statement = connection.
                prepareStatement("insert into image (name, category) values (?,?)");
        statement.setString(1, image.getName());
        statement.setString(2,image.getCategory());
        statement.executeUpdate();

        return ;
    }

}
