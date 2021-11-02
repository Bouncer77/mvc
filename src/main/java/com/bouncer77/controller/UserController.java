package com.bouncer77.controller;

import com.bouncer77.model.User;
import com.bouncer77.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userFromServer", new User());
        modelAndView.setViewName("users_check_page");
        return modelAndView;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody
    String checkLoginUser(@ModelAttribute("userFromServer") User user) {
        if (Objects.nonNull(user) && Objects.nonNull(user.getLogin()) && !user.getLogin().isEmpty()) {
            List<User> users = userService.getAllUsers();

            for (User u : users) {
                if (user.getLogin().equals(u.getLogin())) {
                    //return "Пользователь найден!";
                    return "valid";
                }
            }

        } else {
            if (user.getLogin().isEmpty())
                //return "Login пользователя не введен!";
                return "Login is wrong!";

            // return "Пользователь с логином " + user.getLogin() + " не найден!";
            return "User with login " + user.getLogin() + " not found!";
        }

        return "null";
    }


}
