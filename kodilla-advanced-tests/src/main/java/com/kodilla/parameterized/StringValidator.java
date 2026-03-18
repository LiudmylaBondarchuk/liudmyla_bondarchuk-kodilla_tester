package com.kodilla.parameterized;

public class StringValidator {
    public boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }

}
