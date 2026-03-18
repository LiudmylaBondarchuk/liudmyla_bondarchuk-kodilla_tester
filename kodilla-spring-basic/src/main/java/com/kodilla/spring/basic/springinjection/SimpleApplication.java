package com.kodilla.spring.basic.springinjection;

import org.springframework.stereotype.Component;

@Component
public class SimpleApplication {

    private final MessageService messageService;

    public SimpleApplication(MessageService messageService) {
        this.messageService = messageService;
    }

    public String processMessage(String message, String receiver) {
        if (checkReceiver(receiver)) {
            return this.messageService.send(message, receiver);
        }
        return null;
    }

    private boolean checkReceiver(String receiver) {
        return receiver != null && !receiver.isEmpty();
    }
}
