package com.kodilla.stream;

import java.util.Collections;
import java.util.List;

public class UsersRepository {
    public static List<User> getUsersList() {
        return Collections.unmodifiableList(List.of(
                new User("Walter White", 50, 7, "Chemists"),
                new User("Jessie Pinkman", 25, 4648, "Sales"),
                new User("Tuco Salamanca", 34, 116, "Manager"),
                new User("Gus Firing", 49, 0, "Board"),
                new User("Gale Boetticher", 44, 2, "Chemists"),
                new User("Mike Ehrmantraut", 57, 0, "Security")
        ));
    }
}
