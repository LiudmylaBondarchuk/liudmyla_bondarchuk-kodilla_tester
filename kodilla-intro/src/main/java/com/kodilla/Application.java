package com.kodilla;

public class Application {
    public static void main(String[] args) {
        User[] users = {
                new User("Anna", 20),
                new User("Betty", 33),
                new User("Carl", 58),
                new User("David", 13),
                new User("Eva", 18),
                new User("Frankie", 45)
        };


        int totalAge = 0;
        for(int i = 0; i < users.length; i++) {
            totalAge += users[i].getAge();
        }

        double averageAge = (double) totalAge / users.length;

        System.out.println("Users younger than the average age (" + averageAge + "):");
        for(int i = 0; i < users.length; i++) {
            if (users[i].getAge() < averageAge) {
                System.out.println(users[i].getName());
            }
        }

        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.generate();

        System.out.println("Smallest number: " + randomNumbers.getMin());
        System.out.println("Largest number: " + randomNumbers.getMax());
    }
}
