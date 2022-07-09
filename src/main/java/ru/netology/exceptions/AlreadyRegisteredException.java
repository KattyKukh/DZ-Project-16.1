package ru.netology.exceptions;

public class AlreadyRegisteredException extends RuntimeException {
    private String s;

    public AlreadyRegisteredException(String s) {
        super(s);
    }
}
