package bsu.by.web.command;


import bsu.by.web.dao.UserDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;


public class LoginCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException,ClassNotFoundException {
        String login = req.getParameter("name");
        String password = req.getParameter("password");

        UserDao dao = new UserDao();
        User user = dao.login(login, password);

        if (user != null){
            req.getSession().setAttribute("user", user);
            return "WEB-INF/view/main.jsp";
        }
        else {
            req.setAttribute("error_message", "Incorrect name or password");
            return "index.jsp";
        }
    }

}
