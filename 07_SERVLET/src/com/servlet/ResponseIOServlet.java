package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("UTF-8");//设置服务器字符集

//        resp.setHeader("Content-Type","text/html; charset=UTF-8");//设置浏览器字符集

        //它会同时设置服务器和客户端都使用utf-8字符集，还设置了响应头
        // 此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();


        writer.write("response content文本内容");

//        resp.getOutputStream(); //不同与getWriter同时存在，否则会报错
    }
}
