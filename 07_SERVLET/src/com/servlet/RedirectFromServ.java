package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectFromServ extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("called old servlet");
        //方式一：
        //set the response status: 302 means redirect status
        //redirect status response code indicates that the resource requested has been temporarily moved to the URL given by the Location header.
//        resp.setStatus(302);
        //set response header to declare the new location
//        resp.setHeader("Location", "http://localhost:8080/07_SERVLET/redirectto");

        //方式二：
        resp.sendRedirect("http://localhost:8080/07_SERVLET/redirectto");
    }
}
