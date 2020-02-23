package com.nf.shop.exception;


/**
 * @author DENG-
 */
public class OrderCartNotFoundException extends RuntimeException {

    public OrderCartNotFoundException() {
        super();
    }

    public OrderCartNotFoundException(String message) {
        super(message);
    }

    public OrderCartNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
