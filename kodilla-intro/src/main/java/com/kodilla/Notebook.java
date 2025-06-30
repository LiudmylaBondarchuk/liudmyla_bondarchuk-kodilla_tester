package com.kodilla;

public class Notebook {
    int weight;
    int price;
    int year;

    public Notebook(int weight, int price, int year) {
        this.weight = weight;
        this.price = price;
        this.year = year;
    }

        public void checkPrice () {
            if (this.price < 600) {
                System.out.println("This notebook is cheap.");
            } else if (this.price >= 600 && this.price <= 1000) {
                System.out.println("The price is good.");
            } else {
                System.out.println("This notebook is expensive.");
            }
        }

        public  void checkWeight () {
            if (this.weight <1000) {
                System.out.println("This notebook is light");
            } else if (this.weight >= 1000 && this.weight <= 2000){
                System.out.println("This notebook is not too heavy");
            } else {
                System.out.println("This notebook is very heavy");
            }
        }

        public void assessNotebookCondition() {
            if (this.year > 2023 && this.price > 2500) {
                System.out.println("This is a new and premium notebook");
            } else if (this.year > 2023 && this.price < 2500) {
                System.out.println("This is a new but affordable notebook");
            } else {
                System.out.println("This is an older but still valuable notebook.");
            }
        }
    }


