package com.kodilla;

public class Application {
    public static void main(String[] args) {
        User [] users = {
                new User("Anna", 20),
                new User("Betty", 33),
                new User("Carl", 58),
                new User("David", 13),
                new User("Eva", 18),
                new User("Frankie", 45)
        };

        int totalAge = 0;
        for (User user : users ) {
            totalAge += user.getAge();
            }

        double averageAge = (double) totalAge / users.length;

        System.out.println("Users younger than the average age (" + averageAge + "):");
        for (User user : users) {
            if (user.getAge() < averageAge) {
                System.out.println(user.getName());
            }
        }

        RandomNumbers randomNumbers = new RandomNumbers();
        int [] minMax = randomNumbers.generateNumbers();

        System.out.println("\nRandom number generation task:");
        System.out.println("Smallest number: " + minMax[0]);
        System.out.println("Largest number: " + minMax[1]);
        }
    }
