package ru.fix.javacource.springexample.notebook;

import java.util.Scanner;

public class MainCreateCustomNotebook {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Scanner sc  = new Scanner(System.in);
        String className = sc.nextLine();
        Class c = Class.forName(className);
//        Object o = c.newInstance();
        Notebook n = (Notebook) c.newInstance();
        n.addNote("avc");
        n.addNote("qwerty");
        n.showAllNotes();
    }
}
