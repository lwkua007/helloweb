package bsu.by.web.command.image;

import bsu.by.web.command.Command;
import bsu.by.web.dao.RateDao;
import bsu.by.web.entity.Rate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class RatingImageCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException, ServletException, IOException {

        Double rating = Double.parseDouble(req.getParameter("rating"));
        Integer imageId = Integer.parseInt(req.getParameter("imageId"));
        Integer userId = Integer.parseInt(req.getParameter("userId"));

        RateDao dao = new RateDao();
        Rate rate = dao.findRateById(imageId, userId);

        if (rate != null){
            RateDao daoInsert = new RateDao();
            Rate rateInsert = new Rate(rating, imageId, userId);
            daoInsert.updateRate(rateInsert);
        }
        else {
            RateDao daoUpdate = new RateDao();
            Rate rateUpdate = new Rate(rating, imageId, userId);
            daoUpdate.rate(rateUpdate);
        }

        req.getRequestDispatcher("controller?command=searchImage").include(req, resp);

        return null;
    }
}
