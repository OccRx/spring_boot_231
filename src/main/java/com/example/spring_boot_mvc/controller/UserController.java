package com.example.spring_boot_mvc.controller;

import com.example.spring_boot_mvc.model.User;
import com.example.spring_boot_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public ModelAndView printUser(ModelAndView modelAndView) {
        modelAndView.addObject("userList", userService.findAll());
        modelAndView.setViewName("allUser");
        return modelAndView;
    }



    @GetMapping(value = "/newUserForm")
    public String addUserForm(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @GetMapping(value = "/updateUserForm")
    public String updateForm(@RequestParam(value = "id", required = false) Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(/*@ModelAttribute("user") User user*/Model model, User user) {
        model.addAttribute("user", user);
        userService.add(user);
        return "redirect:/";
    }

    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
