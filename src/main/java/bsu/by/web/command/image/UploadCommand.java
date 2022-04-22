package bsu.by.web.command.image;

import bsu.by.web.command.Command;
import bsu.by.web.dao.UserDao;
import bsu.by.web.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;

public class UploadCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException {


        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDao dao = new UserDao();
        User user = dao.login(email, password);

        if (user != null){
            req.getSession().setAttribute("user", user);
            return "WEB-INF/view/main.jsp";
        }
        else {
            req.setAttribute("error_message", "Incorrect email or password");
            return "index.jsp";
        }
    }
}
