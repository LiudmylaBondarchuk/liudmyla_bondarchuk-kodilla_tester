package com.kodilla.com.optional;
import com.kodilla.com.stream.User;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        User user = new User("user1", 30, 100, "Test");

        Optional<User> optionalUser = Optional.ofNullable(user);

        optionalUser.ifPresent(u -> System.out.println(u.getUsername()));
    }
}

/*
public class OptionalExample {
    public static void main(String[] args) {
        User user = null;
        Optional<User> optionalUser = Optional.ofNullable(user);

        String username =
                optionalUser.orElse(new User("", 0, 0, "")).getUsername();

        System.out.println(username);
    }
}

     */
