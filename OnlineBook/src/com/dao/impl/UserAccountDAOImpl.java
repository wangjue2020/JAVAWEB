package com.dao.impl;

import com.bean.UserAccount;

public class UserAccountDAOImpl extends BaseDAO implements com.dao.UserAccountDAO{
    @Override
    public UserAccount selectUserAccountByUsername(String username) {
        String sql = "select id, username, password, email from USER_ACCOUNT where username=?";
        UserAccount userAccount = selectOne(UserAccount.class, sql, username);
        return userAccount;
    }

    @Override
    public int saveUserAccount(UserAccount userAccount) {
        String sql = "insert into USER_ACCOUNT (username, password, email) values (?, ?, ?)";
        int rows = update(sql, userAccount.getUsername(), userAccount.getPassword(), userAccount.getEmail());
        return rows;
    }

    @Override
    public UserAccount selectUserAccountByUsernameAndPassword(String username, String password) {
        String sql = "select id, username, password, email from USER_ACCOUNT where username=? and password=?";
        UserAccount userAccount = selectOne(UserAccount.class, sql, username,password);
        return userAccount;
    }
}
