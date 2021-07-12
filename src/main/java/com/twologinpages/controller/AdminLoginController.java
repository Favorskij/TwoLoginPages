package com.twologinpages.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminLoginController {

    @GetMapping(value = "/admin/loginAdmin")
    public ModelAndView loginGetMethod () {

        return new ModelAndView("/loginAdmin");
    }


}
