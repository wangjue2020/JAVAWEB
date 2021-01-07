package com.service.impl;

import com.bean.UserAccount;
import com.dao.UserAccountDAO;
import com.dao.impl.UserAccountDAOImpl;
import com.service.UserAccountService;

public class UserAccountServiceImpl implements UserAccountService{
    private UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
    @Override
    public int register(UserAccount user) {
        return userAccountDAO.saveUserAccount(user);
    }

    @Override
    public UserAccount login(UserAccount user) {
        return userAccountDAO.selectUserAccountByUsernameAndPassword(user.getUsername(), user.getPassword());

    }

    @Override
    public boolean existsUsername(String username) {
        UserAccount userAccount = userAccountDAO.selectUserAccountByUsername(username);
        if(userAccount == null)
            return false;
        else
            return true;
    }
}
