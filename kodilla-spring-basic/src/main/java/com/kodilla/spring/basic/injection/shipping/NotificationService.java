package com.kodilla.spring.basic.injection.shipping;

public class NotificationService implements NotificationServiceInterface {

    @Override
    public void success(String address) {
        System.out.println("Package delivered to: " + address);
    }

    @Override
    public void fail(String address) {
        System.out.println("Package not delivered to: " + address);
    }
}
