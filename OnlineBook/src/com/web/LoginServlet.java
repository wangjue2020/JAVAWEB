package com.web;

import com.bean.UserAccount;
import com.service.UserAccountService;
import com.service.impl.UserAccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 不再使用，已经被UserServiceServlet替代
 */
@Deprecated
public class LoginServlet extends HttpServlet{
    private UserAccountService uas = new UserAccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
}
