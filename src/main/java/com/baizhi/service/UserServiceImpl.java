package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public String selectUserByUP(User user) {
        User user1 = userDao.selectByUP(user);
        String message;
        if (user1 == null) {
            message = "用户不存在";
        } else {
            if (user.getPassword().equals(user1.getPassword())) {
                message = "success";
            } else {
                message = "error";
            }
        }
        return message;
    }

    @Override
    public User selectByUP(User user) {
        User user1 = userDao.selectByUP(user);
        return user1;
    }
}
