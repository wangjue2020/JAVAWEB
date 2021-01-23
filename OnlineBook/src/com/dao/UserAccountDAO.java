package com.dao;

import com.bean.UserAccount;

public interface UserAccountDAO {
    /**
     * select user account by username
     * @param username
     * @return
     */
    UserAccount selectUserAccountByUsername(String username);

    int saveUserAccount(UserAccount userAccount);

    UserAccount selectUserAccountByUsernameAndPassword(String username, String password);


}
