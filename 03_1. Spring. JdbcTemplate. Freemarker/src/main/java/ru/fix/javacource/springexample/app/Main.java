package ru.fix.javacource.springexample.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.fix.javacource.springexample.app.dao.UsersDao;
import ru.fix.javacource.springexample.app.models.User;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        UsersDao usersDao = (UsersDao) ac.getBean("usersDao");
        User u = usersDao.find(1);
        System.out.println(u);
    }
}
