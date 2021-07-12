package com.twologinpages.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {

    @GetMapping(value = "/user/loginUser")
    public String loginGetMethod () {

        return "/loginUser";
    }


}
