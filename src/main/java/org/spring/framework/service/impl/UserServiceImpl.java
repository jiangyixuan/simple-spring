package org.spring.framework.service.impl;

import org.spring.framework.User;
import org.spring.framework.service.UserService;

/**
 * @author jiangyixuan
 * @date 2018-03-06
 */
public class UserServiceImpl implements UserService {

    @Override
    public User getUser() {

        User user = new User();
        user.setName("jiangyixuan");
        user.setAge(24);

        return user;
    }
}
