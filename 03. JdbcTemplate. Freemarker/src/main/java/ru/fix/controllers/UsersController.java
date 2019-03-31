package ru.fix.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.fix.dao.UsersDao;
import ru.fix.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class UsersController implements Controller {
    private UsersDao usersDao;

    public UsersController(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<User> users = usersDao.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", users);
//        Integer id = Integer.parseInt(httpServletRequest.getParameter("id"));
//        User u = usersDao.find(id);
//        modelAndView.addObject("username", id);
//        modelAndView.addObject("user", u);
        modelAndView.setViewName("allUsers");
        return modelAndView;
    }
}
