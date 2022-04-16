package bsu.by.web.command;


import bsu.by.web.dao.ImageDao;
import bsu.by.web.entity.Image;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.List;


public class ReadCommand implements Command{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException {

        ImageDao dao = new ImageDao();
        List<Image> images = dao.findAll();
        req.setAttribute("images", images);

        return "WEB-INF/view/read.jsp";
    }
}
