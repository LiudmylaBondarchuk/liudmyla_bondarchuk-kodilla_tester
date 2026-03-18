package com.kodilla.parameterized.validation;

public class Person {

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

    public String getBMI() {
        double bmi = weight / (height * height);

        if (bmi < 15.0) {
            return "Very severely underweight";
        } else if (bmi < 16.0) {
            return "Severely underweight";
        } else if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal (healthy weight)";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else if (bmi < 35.0) {
            return "Obese Class I (Moderately obese)";
        } else if (bmi < 40.0) {
            return "Obese Class II (Severely obese)";
        } else if (bmi < 45.0) {
            return "Obese Class III (Very severely obese)";
        } else if (bmi < 50.0) {
            return "Obese Class IV (Morbidly obese)";
        } else if (bmi < 60.0) {
            return "Obese Class V (Super obese)";
        } else {
            return "Obese Class VI (Hyper Obese)";
        }
    }
}
