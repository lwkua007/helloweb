package bsu.by.web.command;

import bsu.by.web.dao.UserDao;
import bsu.by.web.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;


public class SignupCommand implements Command{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(email, password, 0);
        dao.signUp(user);

        return "index.jsp";
    }
}
