package com.itcluster.advanced.library.controller;

import com.itcluster.advanced.library.model.User;
import com.itcluster.advanced.library.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("basePath")
    private String basePath;

    @ModelAttribute("user")
    public User activeUser(Authentication authentication) {
        return userService.findUserByEmail(authentication.getName()).get();
    }

    @GetMapping("profile")
    public String userProfile() {
        return "user-profile";
    }

    @PostMapping("uploadPhoto")
    public String uploadPhoto(@RequestParam("file") MultipartFile file,
                              @ModelAttribute("user") User user
    ) {
        String uploadName = file.getOriginalFilename();

        try {
            File transferFile = new File(basePath + "/" + uploadName);
            file.transferTo(transferFile);
            log.info("Saved into {}", transferFile.getPath());
            user.setPhoto(uploadName);
            userService.createUpdate(user);
        } catch (IOException e) {
            log.error("Error saving file", e);
        }

        return "redirect:/user/profile";
    }
}
