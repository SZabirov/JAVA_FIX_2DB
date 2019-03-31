package ru.fix.javacource.springexample.springdemo;

public class Worker {
    private Notebook notebook;

    public Worker(Notebook notebook) {
        this.notebook = notebook;
    }

    public void work() {
        for (int i = 0; i < 10; i++) {
            notebook.addNote("i'm worker");
        }
    }
}
