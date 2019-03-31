package ru.fix.javacource.springexample.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WorkerMain {
    public static void main(String[] args) {
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("context.xml");
        Worker w = (Worker) ac.getBean("worker");
        w.work();
    }
}
