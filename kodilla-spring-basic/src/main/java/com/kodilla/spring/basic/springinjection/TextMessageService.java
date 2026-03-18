package com.kodilla.spring.basic.springinjection;
import org.springframework.stereotype.Component;
@Component
public class TextMessageService implements MessageService {
    @Override
    public String send(String message, String receiver) {
        return "Sending text [" + message + "] to: " + receiver;
    }
}
