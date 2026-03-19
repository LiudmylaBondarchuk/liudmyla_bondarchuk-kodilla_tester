package com.kodilla.parameterized.validation;

import java.util.Objects;

public class Person {

    private static final double VERY_SEVERELY_UNDERWEIGHT = 15.0;
    private static final double SEVERELY_UNDERWEIGHT = 16.0;
    private static final double UNDERWEIGHT = 18.5;
    private static final double NORMAL = 25.0;
    private static final double OVERWEIGHT = 30.0;
    private static final double OBESE_I = 35.0;
    private static final double OBESE_II = 40.0;
    private static final double OBESE_III = 45.0;
    private static final double OBESE_IV = 50.0;
    private static final double OBESE_V = 60.0;

    private final double height;
    private final double weight;

    public Person(double height, double weight) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.height = height;
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getBMI() {
        double bmi = weight / (height * height);

        if (bmi < VERY_SEVERELY_UNDERWEIGHT) {
            return "Very severely underweight";
        } else if (bmi < SEVERELY_UNDERWEIGHT) {
            return "Severely underweight";
        } else if (bmi < UNDERWEIGHT) {
            return "Underweight";
        } else if (bmi < NORMAL) {
            return "Normal (healthy weight)";
        } else if (bmi < OVERWEIGHT) {
            return "Overweight";
        } else if (bmi < OBESE_I) {
            return "Obese Class I (Moderately obese)";
        } else if (bmi < OBESE_II) {
            return "Obese Class II (Severely obese)";
        } else if (bmi < OBESE_III) {
            return "Obese Class III (Very severely obese)";
        } else if (bmi < OBESE_IV) {
            return "Obese Class IV (Morbidly obese)";
        } else if (bmi < OBESE_V) {
            return "Obese Class V (Super obese)";
        } else {
            return "Obese Class VI (Hyper Obese)";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(person.height, height) == 0
                && Double.compare(person.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, weight);
    }

    @Override
    public String toString() {
        return "Person{height=" + height + ", weight=" + weight + '}';
    }
}
