package com.fc.controller;

import com.fc.Service.UserService;
import com.fc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("login")
    public ModelAndView login(ModelAndView mv) {
        mv.setViewName("login.html");
        return mv;
    }

    @PostMapping("login")
    public ModelAndView login(String username, String password, ModelAndView mv) {
        User u = userService.find(username, password);

        if (u != null) {
            mv.setViewName("redirect:show.jsp");
        }else {
            mv.addObject("message","账号或密码错误");
        }
        return mv;
    }

}
