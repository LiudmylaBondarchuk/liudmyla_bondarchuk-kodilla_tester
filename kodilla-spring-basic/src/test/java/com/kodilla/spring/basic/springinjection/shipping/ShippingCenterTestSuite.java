package com.kodilla.spring.basic.springinjection.shipping;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("ShippingCenter Spring DI Tests")
class ShippingCenterTestSuite {
    @Test
    @DisplayName("should deliver package within weight limit")
    void shouldDeliverPackage() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        ShippingCenter shippingCenter = context.getBean(ShippingCenter.class);
        String result = shippingCenter.sendPackage("Hill Street 11", 18.2);
        assertEquals("Package delivered to: Hill Street 11", result);
    }
    @Test
    @DisplayName("should fail delivery for heavy package")
    void shouldFailDeliveryForHeavyPackage() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        ShippingCenter shippingCenter = context.getBean(ShippingCenter.class);
        String result = shippingCenter.sendPackage("Main Street 5", 32.0);
        assertEquals("Package not delivered to: Main Street 5", result);
    }
}
