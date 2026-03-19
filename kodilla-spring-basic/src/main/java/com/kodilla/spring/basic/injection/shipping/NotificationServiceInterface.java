package com.kodilla.spring.basic.injection.shipping;

public interface NotificationServiceInterface {
    String success(String address);
    String fail(String address);
}
