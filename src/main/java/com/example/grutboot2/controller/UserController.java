package com.example.grutboot2.controller;

import com.example.grutboot2.model.User;
import com.example.grutboot2.service.UserService;
import com.example.grutboot2.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final UserServiceImpl userServiceImpl;

    public UserController(UserService userService, UserServiceImpl userServiceImpl) {
        this.userService = userService;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    public String users(Model model) {
        model.addAttribute("users", userServiceImpl.findAll());

        return "users";
    }

    @GetMapping("/{id}")
    public String getUser (@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userServiceImpl.findById(id));
        return "user";
    }

    @GetMapping("/new")
    public String addUser(User user) {
        return "create";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            userServiceImpl.saveUser(user);
            return "redirect:/";
        }
    }
//    @PostMapping("/new")
//    public String add(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "create";
//        } else {
//            userService.addUser(user);
//            return "redirect:/";
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userServiceImpl.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute(userServiceImpl.findById(id));
        return "edit";
    }

//    @GetMapping("edit/{id}")
//    public String updateUser(@PathVariable("id") long id, Model model) {
//        model.addAttribute(userService.getUserById(id));
//        return "edit";
//    }

    @PatchMapping("/edit")
    public String update(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            userServiceImpl.saveUser(user);
            return "redirect:/";
        }

//        @PatchMapping("/edit")
//        public String update(@Valid User user, BindingResult bindingResult) {
//            if (bindingResult.hasErrors()) {
//                return "edit";
//            } else {
//                userService.updateUser(user);
//                return "redirect:/";
//            }
    }
}