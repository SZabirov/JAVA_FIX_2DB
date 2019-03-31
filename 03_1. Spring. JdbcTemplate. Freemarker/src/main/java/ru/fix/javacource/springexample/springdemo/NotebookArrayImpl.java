package ru.fix.javacource.springexample.springdemo;

public class NotebookArrayImpl implements Notebook {
    private static final int MAX_NOTES_COUNT = 10;
    private String[] notes;
    private int count;

    public NotebookArrayImpl() {
        notes = new String[MAX_NOTES_COUNT];
        count = 0;
    }

    public void addNote(String note) {
        notes[count++] = note;
    }

    public void showAllNotes() {
        for (int i = 0; i < count; i++) {
            System.out.println(notes[i]);
        }
    }
}
