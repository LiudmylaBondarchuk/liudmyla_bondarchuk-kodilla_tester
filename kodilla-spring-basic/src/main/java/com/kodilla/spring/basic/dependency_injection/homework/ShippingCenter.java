package com.kodilla.spring.basic.dependency_injection.homework;
public class ShippingCenter {

    private DeliveryServiceInterface deliveryService;
    private NotificationServiceInterface notificationService;

    public ShippingCenter(DeliveryServiceInterface deliveryService,
                          NotificationServiceInterface notificationService) {
        this.deliveryService = deliveryService;
        this.notificationService = notificationService;
    }

    public void sendPackage(String address, double weight) {
        if (deliveryService.deliverPackage(address, weight)) {
            notificationService.success(address);
        } else {
            notificationService.fail(address);
        }
    }
}