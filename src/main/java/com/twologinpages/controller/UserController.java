package com.twologinpages.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value = "/user/userPage")
    public String userGetMethod () {
        return "/user";
    }

}
