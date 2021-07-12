package com.twologinpages.controller;

import com.twologinpages.repository.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminLoginController {

    @Autowired
    UserJpa userJpa;


    @GetMapping(value = "/admin/loginAdmin")
    public ModelAndView loginGetMethod () {

        return new ModelAndView("/loginAdmin");
    }


}
