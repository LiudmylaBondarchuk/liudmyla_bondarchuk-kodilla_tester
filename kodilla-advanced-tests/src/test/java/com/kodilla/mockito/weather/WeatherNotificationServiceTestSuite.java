package com.kodilla.mockito.weather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

@DisplayName("WeatherNotificationService Tests")
class WeatherNotificationServiceTestSuite {

    private WeatherNotificationService service;
    private Client client1;
    private Client client2;
    private Client client3;
    private Notification notification;

    @BeforeEach
    void setUp() {
        service = new WeatherNotificationService();
        client1 = mock(Client.class);
        client2 = mock(Client.class);
        client3 = mock(Client.class);
        notification = mock(Notification.class);
    }

    @Test
    void shouldSendNotificationToSubscribersOfLocation() {
        // given
        service.subscribe("Warsaw", client1);
        service.subscribe("Warsaw", client2);
        service.subscribe("Krakow", client3);

        // when
        service.sendNotification("Warsaw", notification);

        // then
        verify(client1, times(1)).receive(notification);
        verify(client2, times(1)).receive(notification);
        verify(client3, never()).receive(notification);
    }

    @Test
    void shouldNotSendNotificationWhenNoSubscribers() {
        // when
        service.sendNotification("Warsaw", notification);

        // then
        verifyNoInteractions(client1);
    }

    @Test
    void shouldSendNotificationToAllSubscribers() {
        // given
        service.subscribe("Warsaw", client1);
        service.subscribe("Krakow", client2);
        service.subscribe("Gdansk", client3);

        // when
        service.sendNotificationToAll(notification);

        // then
        verify(client1, times(1)).receive(notification);
        verify(client2, times(1)).receive(notification);
        verify(client3, times(1)).receive(notification);
    }

    @Test
    void shouldUnsubscribeClientFromLocation() {
        // given
        service.subscribe("Warsaw", client1);
        service.subscribe("Warsaw", client2);

        // when
        service.unsubscribe("Warsaw", client1);
        service.sendNotification("Warsaw", notification);

        // then
        verify(client1, never()).receive(notification);
        verify(client2, times(1)).receive(notification);
    }

    @Test
    void shouldUnsubscribeClientFromAllLocations() {
        // given
        service.subscribe("Warsaw", client1);
        service.subscribe("Krakow", client1);
        service.subscribe("Warsaw", client2);

        // when
        service.unsubscribeFromAll(client1);
        service.sendNotificationToAll(notification);

        // then
        verify(client1, never()).receive(notification);
        verify(client2, times(1)).receive(notification);
    }

    @Test
    void shouldRemoveLocationAndNotNotifySubscribers() {
        // given
        service.subscribe("Warsaw", client1);
        service.subscribe("Warsaw", client2);

        // when
        service.removeLocation("Warsaw");
        service.sendNotification("Warsaw", notification);

        // then
        verify(client1, never()).receive(notification);
        verify(client2, never()).receive(notification);
    }
}
