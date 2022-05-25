package bsu.by.web.command.user;

import bsu.by.web.command.Command;
import bsu.by.web.dao.UserDao;
import bsu.by.web.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class userFuzzyQueryCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException, ServletException, IOException {

        String name = "%" + req.getParameter("name") + "%";

        UserDao dao = new UserDao();
        List<User> users = dao.findByName(name);
        req.setAttribute("users", users);

        return "/WEB-INF/view/query-user.jsp";
    }
}
