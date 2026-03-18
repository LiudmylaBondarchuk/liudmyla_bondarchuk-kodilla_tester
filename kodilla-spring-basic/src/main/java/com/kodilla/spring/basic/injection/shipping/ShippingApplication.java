package com.kodilla.spring.basic.injection.shipping;
public class ShippingApplication {
    public static void main(String[] args) {
        DeliveryServiceInterface deliveryService = new DeliveryService();
        NotificationServiceInterface notificationService = new NotificationService();
        ShippingCenter shippingCenter = new ShippingCenter(deliveryService, notificationService);
        shippingCenter.sendPackage("Hill Street 11, New York", 18.2);
        shippingCenter.sendPackage("Main Street 5, Los Angeles", 32.0);
    }
}
