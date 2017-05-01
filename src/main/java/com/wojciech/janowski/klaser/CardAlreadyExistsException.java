package com.wojciech.janowski.klaser;

public class CardAlreadyExistsException extends Exception {
    private static final long serialVersionUID = -4576295597218170159L;

    public CardAlreadyExistsException() {
    }

    public CardAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
                                      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CardAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardAlreadyExistsException(String message) {
        super(message);
    }

    public CardAlreadyExistsException(Throwable cause) {
        super(cause);

    }
}