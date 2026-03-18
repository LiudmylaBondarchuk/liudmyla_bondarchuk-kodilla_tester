package com.kodilla.stream;

public class AverageAge {

    public static void main(String[] args) {
        double avg = UsersRepository.getUsersList()
                .stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0.0);
        System.out.println(avg);
    }
}
