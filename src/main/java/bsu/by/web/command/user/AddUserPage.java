package bsu.by.web.command.user;


import bsu.by.web.command.Command;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class AddUserPage implements Command {
    @Override
    public String execute (HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException {

        return "WEB-INF/view/add-user.jsp";
}
}
