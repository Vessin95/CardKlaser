package com.wojciech.janowski.klaser;

public class NoSuchCardException extends Exception {
    public NoSuchCardException(String string) {
        super(string);
    }

    public NoSuchCardException() {
    }
}
