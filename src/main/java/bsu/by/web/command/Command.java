package bsu.by.web.command;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


public interface Command {
    String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException, ServletException, IOException;
}
