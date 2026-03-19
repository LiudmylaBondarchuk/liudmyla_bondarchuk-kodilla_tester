package com.kodilla.spring.basic.injection.shipping;

public class ShippingCenter {
    private final DeliveryServiceInterface deliveryService;
    private final NotificationServiceInterface notificationService;

    public ShippingCenter(DeliveryServiceInterface deliveryService,
                          NotificationServiceInterface notificationService) {
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
