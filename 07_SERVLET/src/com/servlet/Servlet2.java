package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("servlet2 checking username: " + username);
        //check whether it is forwarded from servlet1
        Object servlet1 = request.getAttribute("servlet1");
        System.out.println("from servlet1 ? " + servlet1);
        //other logic for servlet2
        System.out.println("servlet2 is handling services...");
    }
}
