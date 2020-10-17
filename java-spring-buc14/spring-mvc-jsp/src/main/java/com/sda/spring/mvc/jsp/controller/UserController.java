package com.sda.spring.mvc.jsp.controller;

import com.sda.spring.mvc.jsp.model.User;
import com.sda.spring.mvc.jsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(name = "/users", method = RequestMethod.GET)
    public String userForm(Model model) {

        // whatever is added to the model will be available in the view
        List<User> userList = userService.getUserList();
        model.addAttribute("users", userList);

        // this view will be returned by the view resolver
        return "index";
    }

    @RequestMapping(value = "/addUser", name = "/addUser", method = RequestMethod.GET)
    public String addUserForm(Model model) {
        // this view will be returned by the view resolver
        model.addAttribute(new User());
        return "addUser";
    }

    // TODO: add user
    @RequestMapping(name = "addUsers", value = "addUser", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user") User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("users", userService.getUserList());
            return "index";
        }

        model.addAttribute("name", user.getName());
        model.addAttribute("email", user.getEmail());

        userService.save(user);
        model.addAttribute("users", userService.getUserList());
        return "index";
    }
}
