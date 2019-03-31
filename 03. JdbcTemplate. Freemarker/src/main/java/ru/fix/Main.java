package ru.fix;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.fix.dao.UsersDao;
import ru.fix.models.User;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersDao usersDao = (UsersDao) applicationContext.getBean("dao");
        User u = usersDao.find(1);
        System.out.println(u);
    }
}
