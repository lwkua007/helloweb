package bsu.by.web.command;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;


public interface Command {
    String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException,ClassNotFoundException;
}
