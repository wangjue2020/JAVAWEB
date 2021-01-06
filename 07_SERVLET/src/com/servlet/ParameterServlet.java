package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取请求参数值
 */
public class ParameterServlet  extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//这一行可以用于避免乱码情况出现，可加可不加，但是一定在获取参数前设置， doPost也可以设置以用于统一字符集
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String habit = req.getParameter("habit");//用于一个parameter只有一个value的情况，如textbook，radio button
        String[] habits = req.getParameterValues("habit");//用于一个parameter有多个value的情况，如checkbox，多选下拉框
        System.out.println(username + ":" + password + ":" + habit);
        for(String s:habits){
            System.out.print(s+"    ");
        }
    }
}
