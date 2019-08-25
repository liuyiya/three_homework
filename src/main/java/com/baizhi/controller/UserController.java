package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(User user, HttpServletRequest request, String code) {

        String message = userService.selectUserByUP(user);

        User user1 = userService.selectByUP(user);
        System.out.println("user:" + user);
        request.getSession().setAttribute("user1", user1);
        System.out.println("message:" + message);
        if (message.equals("success")) {
            return "emplist";
        } else {
            return "login1";
        }

    }
}
