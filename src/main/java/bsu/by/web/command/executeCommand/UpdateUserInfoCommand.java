package bsu.by.web.command.executeCommand;

import bsu.by.web.command.Command;
import bsu.by.web.dao.UserDao;
import bsu.by.web.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


public class UpdateUserInfoCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException, ServletException, IOException {

        Integer userId = Integer.parseInt(req.getParameter("userId"));
        Integer isAdmin = Integer.parseInt(req.getParameter("isAdmin"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Integer state = Integer.parseInt(req.getParameter("state"));
        Double balance = Double.parseDouble(req.getParameter("balance"));

        UserDao dao = new UserDao();
        User user = new User(userId, isAdmin, email, password, state, balance, 0);
        dao.updateUserInfo(user);

        req.getRequestDispatcher("controller?command=queryUser").forward(req, resp);

        return null;
    }
}
