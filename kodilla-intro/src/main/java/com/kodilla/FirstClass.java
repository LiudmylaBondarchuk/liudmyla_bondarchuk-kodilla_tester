package com.kodilla;

public class FirstClass {
    public static void main(String[] args) {
        Notebook notebook = new Notebook(600, 8000, 2025);
        Notebook heavyNotebook = new Notebook(2000, 3000, 2020);
        Notebook oldNotebook = new Notebook(1600, 1000, 2019);

        displayNotebookInfo(notebook, "notebook");
        displayNotebookInfo(heavyNotebook, "heavyNotebook");
        displayNotebookInfo(oldNotebook, "oldNotebook");
    }

    public static void displayNotebookInfo(Notebook notebook, String label) {
        System.out.println(label + ": weight: " + notebook.weight +
                ", price: " + notebook.price + ", year: " + notebook.year);
        notebook.checkWeight();
        notebook.checkPrice();
        notebook.assessNotebookCondition();
    }
}