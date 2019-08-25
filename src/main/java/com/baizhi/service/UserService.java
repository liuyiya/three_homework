package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    String selectUserByUP(User user);

    User selectByUP(User user);
}
