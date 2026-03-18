package com.kodilla.stream.forum;

import com.kodilla.stream.User;
import com.kodilla.stream.UsersRepository;

import java.util.List;
import java.util.function.Predicate;

public class ForumStats {

    public static void main(String[] args) {
        List<User> users = UsersRepository.getUsersList();

        double avgPostsOlderOrEqual40 = averagePostsForUsersOlderThanOrEqual40(users);
        double avgPostsYoungerThan40 = averagePostsForUsersYoungerThan40(users);

        System.out.println("Average number of posts for users >= 40: " + avgPostsOlderOrEqual40);
        System.out.println("Average number of posts for users < 40: " + avgPostsYoungerThan40);
    }

    public static double averagePostsForUsersOlderThanOrEqual40(List<User> users) {
        return averagePosts(users, user -> user.getAge() >= 40);
    }

    public static double averagePostsForUsersYoungerThan40(List<User> users) {
        return averagePosts(users, user -> user.getAge() < 40);
    }

    private static double averagePosts(List<User> users, Predicate<User> filter) {
        return users.stream()
                .filter(filter)
                .mapToInt(User::getNumberOfPost)
                .average()
                .orElse(0);
    }
}
