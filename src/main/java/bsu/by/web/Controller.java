package bsu.by.web;


import bsu.by.web.command.Command;
import bsu.by.web.command.CommandFactory;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException{
        process(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException{
        process(req, resp);
    }


    public void process(HttpServletRequest req, HttpServletResponse resp)
            throws IOException{


        try {
            CommandFactory factory = new CommandFactory();
            String commandParam = req.getParameter("command");
            Command command = factory.create(commandParam);
            String page = command.execute(req, resp);

            req.getRequestDispatcher(page).forward(req, resp);
        } catch (SQLException | ServletException | ClassNotFoundException | FileUploadException e) {
            e.printStackTrace();
        }

    }

}
