package bsu.by.web.command;

import bsu.by.web.dao.ImageDao;
import bsu.by.web.entity.Image;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;

public class UpdateCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException {
        ImageDao dao = new ImageDao();

        String name = req.getParameter("name");
        String category = req.getParameter("category");

        Image image = new Image(null, name, category);
        dao.save(image);

        return "WEB-INF/view/add-image.jsp";
    }
}
