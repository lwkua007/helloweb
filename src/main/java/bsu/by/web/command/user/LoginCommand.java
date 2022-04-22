package bsu.by.web.command.user;


import bsu.by.web.command.Command;
import bsu.by.web.dao.UserDao;
import bsu.by.web.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDao dao = new UserDao();
        User user = dao.login(email, password);

        if (user != null){
            req.getSession().setAttribute("user", user);

            req.getRequestDispatcher("controller?command=search").forward(req, resp);

            return "/WEB-INF/fragments/search.jsp";
        }
        else {
            req.setAttribute("error_message", "Incorrect email or password");
            return "index.jsp";
        }
    }

}
