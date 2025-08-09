package com.kodilla.com.stream;
import java.util.List;
import java.util.stream.Collectors;

public class UsersManager {
    public static void main(String[] args) {
        List<String> chemistGroupUsernames = filterChemistGroupUsernames();
        System.out.println(chemistGroupUsernames);
    }

    public static List<String> filterChemistGroupUsernames() {
        List<String> usernames = UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getGroup().equals("Chemists"))
                .map(UsersManager::getUserName)
                .collect(Collectors.toList());

        return usernames;
    }

    public static String getUserName(User user) {
        return user.getUsername();
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




