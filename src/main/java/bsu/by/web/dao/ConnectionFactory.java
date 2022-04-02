package bsu.by.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String CONNECTION_STRING = "jdbc:mysql://localhost:3306/share_photo";
    private final static String USER = "root";
    private final static String PASSWORD = "lwkua4561230";

    static {
        try {
            Class.forName(DRIVER);

        }
        catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public Connection create() throws SQLException{
        Connection connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        return connection;
    }
}
