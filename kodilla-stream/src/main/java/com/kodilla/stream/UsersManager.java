package com.kodilla.stream;

import java.util.List;
import java.util.stream.Collectors;

public class UsersManager {
    public static void main(String[] args) {
        List<String> chemistGroupUsernames = filterChemistGroupUsernames();
        System.out.println(chemistGroupUsernames);
    }

    public static List<String> filterChemistGroupUsernames() {
        return UsersRepository.getUsersList()
                .stream()
                .filter(user -> "Chemists".equals(user.getGroup()))
                .map(User::getUsername)
                .collect(Collectors.toList());
    }

    public static List<User> filterUsersOlderThan(int ageThreshold) {
        return UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getAge() > ageThreshold)
                .collect(Collectors.toList());
    }

    public static List<User> filterUsersWithMoreThan(int numberOfPosts) {
        return UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getNumberOfPost() > numberOfPosts)
                .collect(Collectors.toList());
    }
}
