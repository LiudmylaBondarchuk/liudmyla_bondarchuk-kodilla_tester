package com.kodilla.parameterized.validation;

public class UserValidator {

    public boolean validateUsername(String username) {
        if (username == null || username.length() < 3 || username.length() > 500) {
            return false;
        }
        if (!username.matches("[a-zA-Z0-9._-]+")) {
            return false;
        }
        if (username.startsWith(".") || username.startsWith("-") ||
            username.endsWith(".") || username.endsWith("-")) {
            return false;
        }
        if (username.contains("..") || username.contains("--")) {
            return false;
        }
        return true;
    }

    public boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        if (email.length() > 500) {
            return false;
        }
        if (email.contains("..")) {
            return false;
        }
        String regex = "^[a-zA-Z][a-zA-Z0-9._+-]*@[a-zA-Z][a-zA-Z0-9-]*(\\.[a-zA-Z]{1,10})+$";
        return email.matches(regex);
    }
}
