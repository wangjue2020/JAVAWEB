package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("URI =>" + req.getRequestURI()); //获取请求的资源路径
        System.out.println("URL =>" + req.getRequestURL()); //获取请求的统一资源定位符（绝对路径）
        System.out.println("Remote Host => " + req.getRemoteHost()); //获取客户端ip地址
        System.out.println("Header => " + req.getHeader("User-Agent")); //获取请求头的内容
        System.out.println("Header => " + req.getHeader("Accept-Language")); //获取请求头的内容
        System.out.println("Method => " + req.getMethod()); //获取请求的方式GET 或者POST
    }
}
