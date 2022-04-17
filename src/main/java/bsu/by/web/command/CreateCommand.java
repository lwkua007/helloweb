package bsu.by.web.command;

import bsu.by.web.dao.ImageDao;
import bsu.by.web.dao.UserDao;
import bsu.by.web.entity.Image;
import bsu.by.web.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;

public class CreateCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();

        Integer isAdmin = Integer.parseInt(req.getParameter("isAdmin"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(isAdmin, email, password);
        dao.create(user);

        return "WEB-INF/view/create.jsp";
    }
}
