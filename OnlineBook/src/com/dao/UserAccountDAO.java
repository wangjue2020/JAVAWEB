package com.dao;

import com.bean.UserAccount;

public interface UserAccountDAO {
    /**
     * select user account by username
     * @param username
     * @return
     */
    public UserAccount selectUserAccountByUsername(String username);

    public int saveUserAccount(UserAccount userAccount);

    public UserAccount selectUserAccountByUsernameAndPassword(String username, String password);


}
