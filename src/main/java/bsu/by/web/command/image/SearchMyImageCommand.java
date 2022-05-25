package bsu.by.web.command.image;

import bsu.by.web.command.Command;
import bsu.by.web.dao.ImageDao;
import bsu.by.web.entity.Image;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class SearchMyImageCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException {

        Integer userId = Integer.parseInt(req.getParameter("userId"));

        ImageDao dao = new ImageDao();
        List<Image> images = dao.findByUserId(userId);

        req.setAttribute("images", images);

        return "WEB-INF/view/my-image.jsp";
    }
}
