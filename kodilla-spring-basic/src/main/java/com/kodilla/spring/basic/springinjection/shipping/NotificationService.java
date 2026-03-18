package com.kodilla.spring.basic.springinjection.shipping;
import org.springframework.stereotype.Service;
@Service
public class NotificationService {
    public String success(String address) { return "Package delivered to: " + address; }
    public String fail(String address) { return "Package not delivered to: " + address; }
}
