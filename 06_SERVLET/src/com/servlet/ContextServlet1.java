package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取servletContext对象
        ServletContext context = getServletContext();
        context.setAttribute("key1","val1");

        System.out.println("ContextServlet1 中 context 获取域数据key1的值为： " + context.getAttribute("key1"));
    }
}
