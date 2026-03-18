package com.kodilla.spring.basic.injection;

public class SimpleApplicationRunner {

    public static void main(String[] args) {
        MessageService messageService = new SkypeMessageService();
        SimpleApplication application = new SimpleApplication(messageService);
        application.processMessage("Test message", "receiver@mail.com");
    }
}
