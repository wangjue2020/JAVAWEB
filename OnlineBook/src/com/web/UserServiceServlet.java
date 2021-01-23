package com.web;

import com.bean.UserAccount;
import com.service.UserAccountService;
import com.service.impl.UserAccountServiceImpl;
import com.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class UserServiceServlet extends BaseServlet{

    private UserAccountService uas = new UserAccountServiceImpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserAccount login = uas.login(new UserAccount(null, username, password, null));
        if(login == null){
            System.out.println("No such user");
            //把错误信息，和回显的表单想信息，保存到request域中
            req.setAttribute("errorMsg", "username or password is not correct!");
            req.setAttribute("username",username);
            req.setAttribute("password", password);

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        UserAccount  ua = WebUtils.copyParamToBean(req.getParameterMap(), new UserAccount());

        System.out.println(ua);
        //要求验证码为abcde
        if("abcde".equalsIgnoreCase(code)){
            if(uas.existsUsername(username)){
                System.out.println("username [" + username + "] already exists");
                req.setAttribute("errorMsg","username already exists");
                req.setAttribute("username", username);
                req.setAttribute("password", password);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else{
                uas.register(new UserAccount(null, username, password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        } else {
            System.out.println("incorrect verify code");
            //把回显的信息存到request域中
            req.setAttribute("errorMsg","验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
