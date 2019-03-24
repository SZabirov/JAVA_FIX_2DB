package app;

import app.dao.UserDao;
import app.dao.UserDaoImpl;
import app.models.User;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/shop_db?user=postgres&password=postgres";
        UserDao userDao = new UserDaoImpl(url);
        User user = new User("John2", "qewrty123");
        System.out.println(userDao.create(user));
    }
}
