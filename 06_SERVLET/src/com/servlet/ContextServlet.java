package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1、获取web.xml中配置的上下文参数context-param
        ServletContext servletContext = getServletConfig().getServletContext();
        System.out.println("context-param参数的sqlusername: " + servletContext.getInitParameter("sqlusername"));
        System.out.println("context-param参数的sqlpassword: " + servletContext.getInitParameter("sqlpassword"));
//        2、获取当前的工程路径，格式:/工程路径
        System.out.println("当前工程路径：" + servletContext.getContextPath());
//        3、获取工程部署后在服务器硬盘上的绝对路径
        // "/" 斜杠被服务器解析地址为http://ip:port/工程名/   映射到IDEA代码的web目录
        System.out.println("获取工程部署后在服务器硬盘上的绝对路径: " + servletContext.getRealPath("/"));
        System.out.println("获取工程部署后在服务器硬盘上的绝对路径: " + servletContext.getRealPath("/web"));
//        4、像Map一样存取数据
    }
}
