package ru.fix.javacource.springexample.app.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "John123");
        modelAndView.setViewName("allUsers");
        return modelAndView;
    }
}
