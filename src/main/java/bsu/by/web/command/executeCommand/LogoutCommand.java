package bsu.by.web.command.executeCommand;


import bsu.by.web.command.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;


public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException {

        return "index.jsp";
    }
}
