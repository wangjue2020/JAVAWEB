package com.web;

import com.bean.UserAccount;
import com.service.UserAccountService;
import com.service.impl.UserAccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet{
    private UserAccountService uas = new UserAccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserAccount login = uas.login(new UserAccount(null, username, password, null));
        if(login == null){
            System.out.println("No such user");
            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
        }else{
            req.getRequestDispatcher("pages/user/login_success.html").forward(req,resp);
        }


    }
}
