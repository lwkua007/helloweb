package bsu.by.web.command.image;

import bsu.by.web.command.Command;
import bsu.by.web.dao.ImageDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class DeleteImageCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException, ServletException, IOException {

        Integer imageId = Integer.parseInt(req.getParameter("imageId"));

        ImageDao dao = new ImageDao();
        dao.deleteImage(imageId);

        req.getRequestDispatcher("controller?command=searchImage").include(req, resp);

        return null;
    }

}
