package com.kodilla.spring.basic.dependency_injection.homework;

public interface NotificationServiceInterface {
    void success(String address);
    void fail(String address);
}