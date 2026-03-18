package com.kodilla.spring.basic.dependency_injection.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("ShippingCenter Tests")
class ShippingCenterTestSuite {

    @Test
    @DisplayName("should notify success when package is within weight limit")
    void shouldNotifySuccessWhenWithinWeightLimit() {
        // given
        DeliveryServiceInterface deliveryService = mock(DeliveryServiceInterface.class);
        NotificationServiceInterface notificationService = mock(NotificationServiceInterface.class);
        when(deliveryService.deliverPackage("123 Main St", 10.0)).thenReturn(true);

        ShippingCenter shippingCenter = new ShippingCenter(deliveryService, notificationService);

        // when
        shippingCenter.sendPackage("123 Main St", 10.0);

        // then
        verify(notificationService).success("123 Main St");
        verify(notificationService, never()).fail("123 Main St");
    }

    @Test
    @DisplayName("should notify failure when package exceeds weight limit")
    void shouldNotifyFailureWhenExceedsWeightLimit() {
        // given
        DeliveryServiceInterface deliveryService = mock(DeliveryServiceInterface.class);
        NotificationServiceInterface notificationService = mock(NotificationServiceInterface.class);
        when(deliveryService.deliverPackage("123 Main St", 50.0)).thenReturn(false);

        ShippingCenter shippingCenter = new ShippingCenter(deliveryService, notificationService);

        // when
        shippingCenter.sendPackage("123 Main St", 50.0);

        // then
        verify(notificationService).fail("123 Main St");
        verify(notificationService, never()).success("123 Main St");
    }
}
