package com.kodilla.com.stream.homework;
import com.kodilla.com.stream.User;
import com.kodilla.com.stream.UsersRepository;

import java.util.List;

public class ForumStats {

    public static void main(String[] args) {
        List<User> users = UsersRepository.getUsersList();

        double avgPostsOlderOrEqual40 = averagePostsForUsersOlderThanOrEqual40(users);
        double avgPostsYoungerThan40 = averagePostsForUsersYoungerThan40(users);

        System.out.println("Average number of posts for users >= 40 lat: " + avgPostsOlderOrEqual40);
        System.out.println("Average number of posts for users < 40 lat: " + avgPostsYoungerThan40);
    }

    public static double averagePostsForUsersOlderThanOrEqual40(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() >= 40)
                .mapToInt(User::getNumberOfPost)
                .average()
                .orElse(0);
    }


    public static double averagePostsForUsersYoungerThan40(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() < 40)
                .mapToInt(User::getNumberOfPost)
                .average()
                .orElse(0);
    }


}