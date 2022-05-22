package bsu.by.web.command.image;

import bsu.by.web.command.Command;
import bsu.by.web.dao.ImageDao;
import bsu.by.web.entity.Image;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadImageCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException, IOException, ServletException, FileUploadException {

        DiskFileItemFactory factory = new DiskFileItemFactory();
        String path = req.getSession().getServletContext().getRealPath("/images");
        File file = new File(path);
        String fileName = null;
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
        factory.setRepository(file);
        factory.setSizeThreshold(1024*1024);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        OutputStream os = null;
        InputStream in = null;

        List<FileItem> list = upload.parseRequest(req);
        Map<String,String> map = new HashMap<>();
        for(FileItem item : list){
            String textName = item.getFieldName();

            if(item.isFormField()){
                String value = item.getString("UTF-8");
                map.put(textName,value);

            }else {
                String value = item.getName();
                int start = value.lastIndexOf("\\");
                fileName = value.substring(start + 1);
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMddHHmmssSSS");
                String timeStamp = simpleDateFormat.format(new Date());
                String newFileName = timeStamp + req.getParameter("userId") + "_" + fileName;

                map.put("location","images"+"/"+ newFileName);
                os = new FileOutputStream(new File(path, newFileName));

                in = item.getInputStream();

                int length = 0;
                byte[] buf = new byte[1024];
                while ((length = in.read(buf)) != -1) {
                    os.write(buf, 0, length);
                }

                in.close();
                os.close();
            }
        }

        String name = map.get("name");
        String category = map.get("category");
        String price = map.get("price");
        Integer userId = Integer.parseInt(req.getParameter("userId"));
        String location = map.get("location");

        ImageDao dao = new ImageDao();
        Image image = new Image(name, category, price, userId, location);
        dao.uploadImageInfo(image);

        req.setAttribute("uploadStateMessage", "Upload Success!");
        req.getSession().setAttribute("image", image);


        return "WEB-INF/view/upload-image.jsp";
    }
}
