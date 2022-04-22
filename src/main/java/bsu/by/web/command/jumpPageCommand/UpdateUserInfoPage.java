package bsu.by.web.command.jumpPageCommand;

import bsu.by.web.command.Command;
import bsu.by.web.dao.UserDao;
import bsu.by.web.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateUserInfoPage implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException, ServletException, IOException {

        Integer userId = Integer.parseInt(req.getParameter("userId"));

        UserDao dao = new UserDao();
        User user = dao.findByUserId(userId);
        req.setAttribute("users", user);

        return "WEB-INF/view/update-user.jsp";
    }
}
