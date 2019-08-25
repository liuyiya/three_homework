package com.baizhi.test;

import com.baizhi.Application;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void test01() {
        User user = new User();
        user.setName("xiaohei");
        user.setPassword("123456");
        String s = userService.selectUserByUP(user);
        System.out.println(s);
    }
}
