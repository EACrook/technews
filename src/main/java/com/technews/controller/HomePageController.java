package com.technews.controller;

import com.technews.repository.CommentRepository;
import com.technews.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.Thymeleaf;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;

@Controller
public class HomePageController {

    @Autowired
    UserController userController;

    @Autowired
    PostController postController;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/login")
//    Model model is inherited functionality from Spring
    public String login(Model model, HttpServletRequest request) {

        if (request.getSession(false) != null) {
            return "redirect:/";
        }

//        add attribute method is built into the Model object and sends info to the Thymeleaf templates--in this case it is sent to the string user
        model.addAttribute("user", new User());
        return "login";
    }
}
