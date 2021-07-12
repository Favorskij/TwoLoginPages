package com.twologinpages.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginController {

    @GetMapping(value = "/admin/loginAdmin")
    public String loginGetMethod () {

        return "/loginAdmin";
    }


}
