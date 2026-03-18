package com.kodilla.spring.basic.injection.shipping;
public interface NotificationServiceInterface {
    void success(String address);
    void fail(String address);
}
