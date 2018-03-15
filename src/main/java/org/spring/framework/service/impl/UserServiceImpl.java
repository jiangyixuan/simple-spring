package org.spring.framework.service.impl;

import org.spring.framework.User;
import org.spring.framework.annottation.Service;
import org.spring.framework.helper.DBHelper;
import org.spring.framework.service.UserService;

import java.util.UUID;

/**
 * @author jiangyixuan
 * @date 2018-03-06
 */
@Service()
public class UserServiceImpl implements UserService {

    @Override
    public User getUser() {

        User user = new User();
        user.setName("jiangyixuan");
        user.setAge(24);

        return user;
    }

    @Override
    public Integer insertUser() {
        Integer rows = 0;
        try {
            //开启事务
            DBHelper.beginTransaction();
            String sql = "INSERT INTO `user` VALUES (?, ?, ?);";
            Object[] params = {UUID.randomUUID().toString(), "2", 2};

            rows = DBHelper.update(sql, params);
        } catch (Exception e) {
            // 回滚事务
            DBHelper.rollbackTransaction();
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            //提交事务
            DBHelper.commitTransaction();
        }
        return rows;
    }
}
