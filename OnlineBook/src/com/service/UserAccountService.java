package com.service;

import com.bean.UserAccount;

public interface UserAccountService {
    /**
     * sign up
     * @param user
     */
    public int register(UserAccount user);

    /**
     * sign in
     * @param user
     * @return
     */
    public UserAccount login(UserAccount user);

    /**
     * check whether the username is already existing
     * @param username
     * @return
     */
    public boolean existsUsername(String username);

}
