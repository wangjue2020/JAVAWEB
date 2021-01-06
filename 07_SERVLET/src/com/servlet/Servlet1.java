package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet请求转发
 * 请求转发的特点：
 * 1、浏览器地址栏没有变化，不会变到转发后的地址
 * 2、他们是一次请求
 * 3、他们共享Request域中的数据
 * 4、可以转发到WEB-INFO目录下
 * 5、不能访问工程以外的资源
 */
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("servlet1 checking username: " + username);
        request.setAttribute("servlet1", "true");
        /*
        请求转发必须要以斜杠打头， / 斜杠表示地址为http://ip:port/工程名/, 映射到IDEA代码的web目录
         */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");//找到转发目的地的调度
        requestDispatcher.forward(request,response);
    }
}
