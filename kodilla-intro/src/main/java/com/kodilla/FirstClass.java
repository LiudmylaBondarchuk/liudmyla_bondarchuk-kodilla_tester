package com.kodilla;

public class FirstClass {
    public static void main(String[] args) {

        Notebook notebook = new Notebook(600, 8000, 2025);
        System.out.println("notebook.weight: " + notebook.weight +
                "" + ", notebook.price:" + notebook.price +
                "" + ", year:" + notebook.year);
        notebook.checkPrice();
        notebook.checkWeight();
        notebook.assessNotebookCondition();


        Notebook heavyNotebook = new Notebook(2000, 3000, 2020);
        System.out.println("heavyNotebook:" + heavyNotebook.weight +
                "" + ", heavyNotebook.price:" + heavyNotebook.price +
                "" + ", year:" + heavyNotebook.year);
        heavyNotebook.checkPrice();
        heavyNotebook.checkWeight();
        heavyNotebook.assessNotebookCondition();


        Notebook oldNotebook = new Notebook(1600, 1000, 2019);
        System.out.println("oldNotebook:" + oldNotebook.weight +
                "" + ", oldNotebook.price:" + oldNotebook.price +
                "" + ", year:" + oldNotebook.year);
        oldNotebook.checkPrice();
        oldNotebook.checkWeight();
        oldNotebook.assessNotebookCondition();


    }
}
