package com.test;

import com.bean.UserAccount;
import com.service.UserAccountService;
import com.service.impl.UserAccountServiceImpl;
import org.junit.Test;

public class UserAccountServiceImplTest {
    UserAccountService uas = new UserAccountServiceImpl();
    @Test
    public void register() {
        int res = uas.register(new UserAccount(1, "business", "test", "business@mail.com"));
        System.out.println(res);
    }


    @Test
    public void login() {
        UserAccount res = uas.login(new UserAccount(1, "business","test","business"));
        System.out.println(res);
    }

    @Test
    public void existsUsername() {
        boolean bussiness = uas.existsUsername("business");
        System.out.println(bussiness);
    }
}