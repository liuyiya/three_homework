package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao {
    User selectByUP(User user);
}
