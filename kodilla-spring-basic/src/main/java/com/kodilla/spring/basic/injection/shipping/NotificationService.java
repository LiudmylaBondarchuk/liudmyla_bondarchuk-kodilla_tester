package com.kodilla.spring.basic.injection.shipping;

public class NotificationService implements NotificationServiceInterface {

    @Override
    public String success(String address) {
        return "Package delivered to: " + address;
    }

    @Override
    public String fail(String address) {
        return "Package not delivered to: " + address;
    }
}
