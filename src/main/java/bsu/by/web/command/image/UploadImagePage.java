package bsu.by.web.command.image;

import bsu.by.web.command.Command;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class UploadImagePage implements Command {
    @Override
    public String execute (HttpServletRequest req, HttpServletResponse resp)
        throws SQLException, ClassNotFoundException {

        return "/WEB-INF/view/upload-image.jsp";
    }
}
