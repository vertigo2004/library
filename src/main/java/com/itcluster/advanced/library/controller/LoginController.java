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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class LoginController implements WebMvcConfigurer {

    private static final String EMAIL_ALREADY_USED_MESSAGE ="There is already a user registered with the email provided";
    private static final String SUCCESSFULLY_REGISTERED_MESSAGE = "User has been registered successfully";

    @Autowired
    private UserService userService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @ModelAttribute("user")
    public User activeUser(Authentication authentication) {
        return new User();
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createNewUser(@Valid User user,
                                BindingResult bindingResult,
                                Model model
    ) {
        if (bindingResult.hasErrors() || userExists(user, bindingResult))  {
            return "registration";
        }

        user = userService.createUpdate(user);
        model.addAttribute("successMessage", SUCCESSFULLY_REGISTERED_MESSAGE);
        return "homepage";
    }

    private boolean userExists(User user, BindingResult bindingResult) {
        boolean result = userService.findUserByEmail(user.getEmail()).isPresent();
        if (result) {
            bindingResult.rejectValue("email", "error.user", EMAIL_ALREADY_USED_MESSAGE);
        }
        return result;
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
