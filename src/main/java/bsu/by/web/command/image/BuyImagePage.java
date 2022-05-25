package bsu.by.web.command.image;

import bsu.by.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class BuyImagePage implements Command {
    @Override
    public String execute (HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException {

        return "/WEB-INF/view/buy-image.jsp";
    }
}
