package com.kodilla.mockito.homework;

import java.util.*;

public class WeatherNotificationService {

    private final Map<String, Set<Client>> locationSubscribers = new HashMap<>();

    public void subscribe(String location, Client client) {
        locationSubscribers.computeIfAbsent(location, k -> new HashSet<>()).add(client);
    }

    public void unsubscribe(String location, Client client) {
        Set<Client> subscribers = locationSubscribers.get(location);
        if (subscribers != null) {
            subscribers.remove(client);
            if (subscribers.isEmpty()) {
                locationSubscribers.remove(location);
            }
        }
    }

    public void unsubscribeFromAll(Client client) {
        for (Set<Client> subscribers : locationSubscribers.values()) {
            subscribers.remove(client);
        }
        locationSubscribers.entrySet().removeIf(e -> e.getValue().isEmpty());
    }

    public void sendNotification(String location, Notification notification) {
        Set<Client> subscribers = locationSubscribers.get(location);
        if (subscribers != null) {
            for (Client client : subscribers) {
                client.receive(notification);
            }
        }
    }

    public void sendNotificationToAll(Notification notification) {
        Set<Client> allClients = new HashSet<>();
        for (Set<Client> subscribers : locationSubscribers.values()) {
            allClients.addAll(subscribers);
        }
        for (Client client : allClients) {
            client.receive(notification);
        }
    }

    public void removeLocation(String location) {
        locationSubscribers.remove(location);
    }
}
