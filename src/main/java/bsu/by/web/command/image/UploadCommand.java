package bsu.by.web.command.image;

import bsu.by.web.command.Command;
import bsu.by.web.dao.ImageDao;
import bsu.by.web.entity.Image;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException, IOException, ServletException, FileUploadException {

//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        String path = req.getSession().getServletContext().getRealPath("/images");
//        File file = new File(path);
//        String filename = null;
//        if (!file.exists() && !file.isDirectory()) {
//            file.mkdir();
//        }
//        factory.setRepository(file);
//        factory.setSizeThreshold(1024*1024);
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        upload.setHeaderEncoding("UTF-8");
//        OutputStream os = null;
//        InputStream in = null;
//
//        List<FileItem> list = upload.parseRequest((RequestContext) req);
//        Map<String,String> map=new HashMap<>();
//        for(FileItem item : list){
//            String name1 = item.getFieldName();
//
//            if(item.isFormField()){
//                String value = item.getString("UTF-8");
//                map.put(name1,value);
//
//            }else {
//                //处理非文本类型数据类似图片,pdf,rar等等
//                //分三步走
//                //1.获取路径名
//                String value = item.getName();
//                //2.处理反斜杠
//                int start = value.lastIndexOf("\\");
//                //得到文件名，去除反斜杠前面的内容
//                //String images = req.getParameter("images");
//                filename = value.substring(start + 1);
//
//                map.put("image","images"+"/"+filename);
//                //3.准备写入
//                //上传需要读写流
//                os = new FileOutputStream(new File(path, filename));
//
//                in = item.getInputStream();
//
//                int length = 0;
//                byte[] buf = new byte[1024];
//                while ((length = in.read(buf)) != -1) {
//                    os.write(buf, 0, length);
//                }
//
//                in.close();
//                os.close();
//            }
//        }
//
//        String name = map.get("name");
//        String category = map.get("category");
//        String price = map.get("price");
//        Integer userId = Integer.parseInt(map.get("userId"));
//        String location = map.get("location");

//        ImageDao dao = new ImageDao();
//        Image image = new Image(name, category, price, userId, location);
//        dao.uploadImageInfo(image);

        req.setAttribute("uploadStateMessage", "Upload Success!");

        return "WEB-INF/view/upload-image.jsp";
    }
}
