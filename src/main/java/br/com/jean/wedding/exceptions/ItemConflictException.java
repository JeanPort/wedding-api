package br.com.jean.wedding.exceptions;

public class ItemConflictException extends RuntimeException{

    public ItemConflictException(String message) {
        super(message);
    }
}
