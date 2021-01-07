package com.web;

import com.bean.UserAccount;
import com.service.UserAccountService;
import com.service.impl.UserAccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet{
    private UserAccountService uas = new UserAccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //要求验证码为abcde
        if("abcde".equalsIgnoreCase(code)){
            if(uas.existsUsername(username)){
                System.out.println("username [" + username + "] already exists");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            } else{
                uas.register(new UserAccount(null, username, password,email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }

        } else {
            System.out.println("incorrect verify code");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        }
        System.out.println(username);
        System.out.println(password);
        System.out.println(email);
        req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);

    }
}
