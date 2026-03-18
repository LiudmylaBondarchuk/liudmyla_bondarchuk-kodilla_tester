package com.kodilla.spring.basic.springinjection.shipping;
import org.springframework.stereotype.Component;
@Component
public class ShippingCenter {
    private final DeliveryService deliveryService;
    private final NotificationService notificationService;
    public ShippingCenter(DeliveryService deliveryService, NotificationService notificationService) {
        this.deliveryService = deliveryService;
        this.notificationService = notificationService;
    }
    public String sendPackage(String address, double weight) {
        if (deliveryService.deliverPackage(address, weight)) {
            return notificationService.success(address);
        }
        return notificationService.fail(address);
    }
}
