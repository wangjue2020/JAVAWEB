package com.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet{
    public HelloServlet() {
        System.out.println("Constructor is running");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init method is running");

//        1、可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet's servlet-name is " + servletConfig.getServletName());
//        2、获取初始化init-param
        System.out.println("init param of username is: " + servletConfig.getInitParameter("username"));
        System.out.println("init param of password is: " + servletConfig.getInitParameter("password"));
//        3、获取servletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * Service 方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.print("Service method is running ---");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if("GET".equals(httpServletRequest.getMethod()))
            doGet();
        else
            doPost();
    }

    /*
    get service
     */
    public void doGet(){
        System.out.println("[GET] service is running");
    }

    /*
    post service
     */
    public void doPost(){
        System.out.println("[POST] service is running");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy method is running ");
    }
}
