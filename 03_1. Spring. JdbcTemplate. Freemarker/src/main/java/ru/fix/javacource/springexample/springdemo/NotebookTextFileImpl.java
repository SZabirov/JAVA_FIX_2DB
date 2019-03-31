package ru.fix.javacource.springexample.springdemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class NotebookTextFileImpl implements Notebook {
    private String filename;

    public NotebookTextFileImpl(String filename) {
        this.filename = filename;
    }

    public void addNote(String note) {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(filename, true));
            pw.println(note);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void showAllNotes() {

    }
}
