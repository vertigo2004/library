package com.itcluster.advanced.library.controller;

import com.itcluster.advanced.library.model.User;
import com.itcluster.advanced.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value={"/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
        Optional<User> userExists = userService.findUserByEmail(user.getEmail());
        if (userExists.isPresent()) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (!bindingResult.hasErrors()) {
            user = userService.create(user);
            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("user", user);
            return "homepage";
        }
        return "registration";
    }

    @GetMapping("/admin/home")
    public String home(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName()).get();
        model.addAttribute("userName", "Welcome " + user.getFirstname() + " " + user.getLastname() + " (" + user.getEmail() + ")");
        model.addAttribute("adminMessage","Content Available Only for Users with Admin Role");

        return "admin/home";
    }
}
