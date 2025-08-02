package com.kodilla.collections.adv.immutable;

public class ImmutableExample {
    public static void main(String[] args) {
        Book book = new Book("John Stewart", "The last chance");
        BookRecord bookRecord = new BookRecord("test", "testowa pozycja", 2022);

        System.out.println(bookRecord);
    }
}