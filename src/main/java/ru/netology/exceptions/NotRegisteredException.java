package ru.netology.exceptions;

public class NotRegisteredException extends RuntimeException {
    private String s;

    public NotRegisteredException(String s) {
        super(s);
    }
}
