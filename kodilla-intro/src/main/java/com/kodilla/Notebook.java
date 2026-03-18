package com.kodilla;

public class Notebook {
    private static final double CHEAP_PRICE_THRESHOLD = 600;
    private static final double GOOD_PRICE_THRESHOLD = 1000;
    private static final double PREMIUM_PRICE_THRESHOLD = 2500;
    private static final double LIGHT_WEIGHT_THRESHOLD = 1000;
    private static final double MEDIUM_WEIGHT_THRESHOLD = 2000;
    private static final int NEW_YEAR_THRESHOLD = 2023;

    private final double weight;
    private final double price;
    private final int year;

    public Notebook(double weight, double price, int year) {
        this.weight = weight;
        this.price = price;
        this.year = year;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public void checkPrice() {
        if (price < CHEAP_PRICE_THRESHOLD) {
            System.out.println("This notebook is cheap.");
        } else if (price <= GOOD_PRICE_THRESHOLD) {
            System.out.println("The price is good.");
        } else {
            System.out.println("This notebook is expensive.");
        }
    }

    public void checkWeight() {
        if (weight < LIGHT_WEIGHT_THRESHOLD) {
            System.out.println("This notebook is light");
        } else if (weight <= MEDIUM_WEIGHT_THRESHOLD) {
            System.out.println("This notebook is not too heavy");
        } else {
            System.out.println("This notebook is very heavy");
        }
    }

    public void assessNotebookCondition() {
        if (year > NEW_YEAR_THRESHOLD && price > PREMIUM_PRICE_THRESHOLD) {
            System.out.println("This is a new and premium notebook");
        } else if (year > NEW_YEAR_THRESHOLD) {
            System.out.println("This is a new but affordable notebook");
        } else {
            System.out.println("This is an older but still valuable notebook.");
        }
    }
}
