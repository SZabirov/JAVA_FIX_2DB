package ru.fix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fix.models.User;
import ru.fix.services.UsersService;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public String getAll(Model model) {
        List<User> allUsers = usersService.getAll();
        model.addAttribute("userList", allUsers);
        return "users_page";
    }

    @GetMapping("/users/{user-id}")
    public String getById(Model model,
                          @PathVariable(name = "user-id") Integer id) {
        User u = usersService.getById(id);
        model.addAttribute("user", u);
        return "profile_page";
    }

    @GetMapping(value = "/users", params = {"username"})
    public String getByUsername(Model model,
                                @RequestParam String username) {
        User u = usersService.getByUsername(username);
        model.addAttribute("user", u);
        return "profile_page";
    }
}









