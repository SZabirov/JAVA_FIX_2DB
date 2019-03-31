package ru.fix.javacource.springexample.notebook;

import java.lang.reflect.Field;

public class MainReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("ru.fix.javacource.springexample.notebook.NotebookArrayImpl");
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getType() + " " + f.getName());
        }
    }
}
