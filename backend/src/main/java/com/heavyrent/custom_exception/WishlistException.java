package com.heavyrent.custom_exception;

public class WishlistException extends RuntimeException {
    public WishlistException(String message) {
        super(message);
    }
}
