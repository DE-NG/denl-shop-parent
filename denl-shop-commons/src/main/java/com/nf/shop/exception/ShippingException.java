package com.nf.shop.exception;

/**
 * Description:<描述>
 * @author DENG-
 */
public class ShippingException extends RuntimeException {
    public ShippingException() {
        super();
    }

    public ShippingException(String message) {
        super(message);
    }

    public ShippingException(String message, Throwable cause) {
        super(message, cause);
    }
}
