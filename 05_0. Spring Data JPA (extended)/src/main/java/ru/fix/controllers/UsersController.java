package ru.fix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fix.models.User;
import ru.fix.repositories.UsersRepository;
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


    @GetMapping("/usershavingproductsmorethanlimit")
    public String getAllUsersHavingMoreThanLimit(Model model,
                                               @RequestParam Integer minCost) {
        List<User> allUsers = usersService
                .getAllUsersHavingProductsMoreThanLimit(minCost);
        model.addAttribute("userList", allUsers);
        return "users_page";
    }

    @GetMapping("/userswithproductscount")
    public String getAllUsersWithProductsCount(Model model,
                                               @RequestParam Integer minCost) {
        List<UsersRepository.UsersWithProductCounts> usersWithProductCountsList =
                usersService.getAllUsersWithCountHavingProductsMoreThanLimit(minCost);
        model.addAttribute("usersWithProductCountsList",
                usersWithProductCountsList);
        return "users_with_products_count_page";
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

    @GetMapping("/someuser")
    public String getSomeUser(Model model) {
        model.addAttribute("user",
                usersService.getSomeUser());
        return "profile_page";
    }
}









