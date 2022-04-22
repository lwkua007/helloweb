package bsu.by.web.command.jumpPageCommand;

import bsu.by.web.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class QueryUserPage implements Command {
    @Override
    public String execute (HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException, ServletException, IOException {

        req.getRequestDispatcher("controller?command=queryUser").forward(req, resp);

        return "WEB-INF/view/query-user.jsp";
    }
}
