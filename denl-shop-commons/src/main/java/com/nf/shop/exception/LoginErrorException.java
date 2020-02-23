package com.nf.shop.exception;

/**
 * @Author:DENG-
 * @Date:2019/12/9 15:26
 */
public class LoginErrorException extends RuntimeException {
    public LoginErrorException() {
        super();
    }

    public LoginErrorException(String message) {
        super(message);
    }

    public LoginErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
