package com.kodilla.spring.basic.springinjection.shipping;
import org.springframework.stereotype.Service;
@Service
public class DeliveryService {
    public boolean deliverPackage(String address, double weight) {
        if (weight > 30) { return false; }
        return true;
    }
}
