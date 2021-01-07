package com.test;

import com.bean.UserAccount;
import com.dao.UserAccountDAO;
import com.dao.impl.UserAccountDAOImpl;
import org.junit.Test;

public class UserAccountDAOTest {

    private UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
    @Test
    public void selectUserAccountByUsername() {
        System.out.println("==========start selectUserAccountByUsername===========");
        System.out.println(userAccountDAO.selectUserAccountByUsername("admin"));
        System.out.println(userAccountDAO.selectUserAccountByUsername("hello"));
        System.out.println("==========finish selectUserAccountByUsername===========");
        System.out.println();
    }

    @Test
    public void saveUserAccount() {
        System.out.println("==========start saveUserAccount===========");
        int rows = userAccountDAO.saveUserAccount(new UserAccount(2, "root", "admin", "root@amdin.com"));
        System.out.println(rows);
        System.out.println("==========finish saveUserAccount===========");
        System.out.println();
    }

    @Test
    public void selectUserAccountByUsernameAndPassword() {
        System.out.println("==========start selectUserAccountByUsernameAndPassword===========");
        UserAccount userAccount = userAccountDAO.selectUserAccountByUsernameAndPassword("root", "admin");
        System.out.println(userAccount);
         userAccount = userAccountDAO.selectUserAccountByUsernameAndPassword("root", "root");
        System.out.println(userAccount);
        System.out.println("==========start selectUserAccountByUsernameAndPassword===========");
        System.out.println();


    }
}