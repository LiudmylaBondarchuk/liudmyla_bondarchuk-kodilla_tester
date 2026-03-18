package com.kodilla;

public class Application26 {
    public static void main(String[] args) {
        UserStatisticsApp user1 = new UserStatisticsApp("Adam", 40, 178);
        System.out.println("User: " + user1.getName() + ", Age: "
                + user1.getAge() + ", Height: " + user1.getHeight());
        user1.checkAgeAndHeight();
    }
}
