package com.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet{
    /**
     * 用来处理文件上传
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        //1. 先判断上传的数据是否多段数据（只有是多端的数据，才是文件上传的）
        if(ServletFileUpload.isMultipartContent(req)){
            //2、创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //解析上传的数据，得到每一个表单项
                List<FileItem> list = servletFileUpload.parseRequest(req);

                for(FileItem fileItem:list){
                    if(fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name属性值： " + fileItem.getName());
                        System.out.println("表单项的value属性值： " + fileItem.getString());
                    } else {
                        //上传的文件

                        System.out.println("表单项的name属性值： " + fileItem.getName());
                        System.out.println("表单项的value属性值： " + fileItem.getString());
                        fileItem.write(new File("/Users/Wangjue/IdeaProjects/JAVAWEB/09_UPLOAD_FILE/"+fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
