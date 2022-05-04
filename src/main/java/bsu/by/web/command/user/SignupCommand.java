package bsu.by.web.command.user;

import bsu.by.web.command.Command;
import bsu.by.web.dao.UserDao;
import bsu.by.web.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;


import java.sql.SQLException;


public class SignupCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();

        String email = req.getParameter("email");
        String password = DigestUtils.md5Hex(req.getParameter("password"));

        User user = new User(0, email, password, 1, .0);
        dao.signUp(user);

        return "index.jsp";
    }
}
