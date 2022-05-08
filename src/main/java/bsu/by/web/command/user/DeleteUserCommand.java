package bsu.by.web.command.user;

import bsu.by.web.command.Command;
import bsu.by.web.dao.UserDao;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException, ServletException, IOException {

        Integer userId = Integer.parseInt(req.getParameter("userId"));

        UserDao dao = new UserDao();
        dao.deleteUser(userId);

        req.getRequestDispatcher("controller?command=queryUser").forward(req, resp);

        return null;
    }
}
