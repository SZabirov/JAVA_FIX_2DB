package ru.fix.javacource.springexample.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("context.xml");
        Notebook n = (Notebook) ac.getBean("textNotebook");
        n.addNote("privet");
    }
}
