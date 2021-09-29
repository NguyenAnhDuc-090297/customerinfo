package com.securemetric.infomanager.controller;

import com.securemetric.infomanager.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

//    private User getPrincipal(){
//        User user = null;
//        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
//            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        }
//        return user;
//    }

    @GetMapping("/access-denied")
    public String accessDeniedPage(){
        return "denied";
    }
}
