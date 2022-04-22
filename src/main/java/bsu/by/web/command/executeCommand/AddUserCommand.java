package bsu.by.web.command.executeCommand;

import bsu.by.web.command.Command;
import bsu.by.web.dao.UserDao;
import bsu.by.web.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;

public class AddUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();

        Integer isAdmin = Integer.parseInt(req.getParameter("isAdmin"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Integer state = Integer.parseInt(req.getParameter("state"));
        Double balance = Double.parseDouble(req.getParameter("balance"));

        User user = new User(0, isAdmin, email, password, state, balance, 0);
        dao.addUser(user);

        req.setAttribute("addStateMessage", "Added Success!");

        return "WEB-INF/view/add-user.jsp";
    }
}
