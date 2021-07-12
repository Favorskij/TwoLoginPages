package com.twologinpages.controller;

import com.twologinpages.model.user.User;
import com.twologinpages.repository.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLoginController {

    @Autowired
    UserJpa userJpa;


    @GetMapping(value = "/user/loginUser")
    public ModelAndView loginGetMethod () {

        return new ModelAndView("/loginUser");
    }


}
