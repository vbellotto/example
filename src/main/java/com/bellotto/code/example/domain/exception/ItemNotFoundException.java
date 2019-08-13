package com.bellotto.code.example.domain.exception;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

public class ItemNotFoundException extends Exception {

    private final String ITEM_NOT_FOUND = "Item with the id %s could not be found.";

    private HttpStatus errorCode;
    private String message;
    /**
     * The default constructor.
     */
    public ItemNotFoundException(final Long id){
        this.errorCode = HttpStatus.NOT_FOUND;
        this.message = String.format(ITEM_NOT_FOUND, String.valueOf(id));
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
