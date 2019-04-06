package ru.fix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String greeting(Model model) {
        model.addAttribute("name", "Salavat");
        return "hello_page";
    }

    @GetMapping("/goodbye")
    public String bye(Model model,
                      @RequestParam String name) {
        model.addAttribute("name", name);
        return "bye_page";
    }

}
