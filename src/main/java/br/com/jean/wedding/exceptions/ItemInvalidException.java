package br.com.jean.wedding.exceptions;

public class ItemInvalidException extends RuntimeException{
    public ItemInvalidException(String message) {
        super(message);
    }
}
