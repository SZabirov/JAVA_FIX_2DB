package ru.fix.javacource.springexample.notebook;

public class Main {
    public static void main(String[] args) {
        Notebook n = new NotebookTextFileImpl();
        n.addNote("Привет");
        n.addNote("Как дела");
        n.showAllNotes();
    }
}
