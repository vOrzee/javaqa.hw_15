package ru.netology.exceptions;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String message) {
        super(message);
    }

    public NotRegisteredException() {
        super();
    }
}
