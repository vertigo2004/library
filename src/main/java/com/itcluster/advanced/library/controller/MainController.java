package com.itcluster.advanced.library.controller;

import com.itcluster.advanced.library.model.User;
import com.itcluster.advanced.library.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@Slf4j
public class MainController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User activeUser(Authentication authentication) {

        return authentication == null ? null : userService.findUserByEmail(authentication.getName()).get();
    }

    @GetMapping("/")
    public String homePage() {
        return "homepage";
    }

    @GetMapping("dashboard")
    public String dashboard() {
        return "dashboard";
    }

}
