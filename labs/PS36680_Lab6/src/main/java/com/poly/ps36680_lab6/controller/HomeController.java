package com.poly.ps36680_lab6.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class HomeController {

    @Autowired
    HttpServletRequest req;

    @RequestMapping("/home/index")
    public String index(Model model) {
        model.addAttribute("message", "This is home page");
        return "home/index";
    }

    @RequestMapping("/home/about")
    public String about(Model model) {
        model.addAttribute("message", "This is introduction page");
        return "home/index";
    }

    @RequestMapping("/home/admins")
    public String admins(Model model) {
        /* 3.Programing */
        if (!req.isUserInRole("ADMIN")) {
            return "redirect:/auth/access/denied";
        }
        model.addAttribute("message", "Hello admin");
        return "home/index";
    }


    @RequestMapping("/home/users")
    public String users(Model model) {
        /* 3.Programing */
        if (!(req.isUserInRole("ADMIN") || req.isUserInRole("USER"))) {
            return "redirect:/auth/access/denied";
        }
        model.addAttribute("message", "Hello staff");
        return "home/index";
    }

    @RequestMapping("/home/authenticated")
    public String authenticated(Model model) {
        /* 3.Programing */
        if (req.getRemoteUser() == null) {
            return "redirect:/auth/access/denied";
        }
        model.addAttribute("message", "Hello authenticated user");
        return "home/index";
    }

//    @RequestMapping("/home/thymeleaf1")
//    public String thymeleaf1(Model model) {
//        model.addAttribute("message", "Thymleaf - Without Extras");
//        return "home/thymeleaf1";
//    }

    @RequestMapping("/home/thymeleaf2")
    public String thymeleaf2(Model model) {
        model.addAttribute("message", "Thymleaf - With Extras");
        return "home/thymeleaf2";
    }

}
