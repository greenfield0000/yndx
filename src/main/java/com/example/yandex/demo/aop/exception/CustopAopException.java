package com.example.yandex.demo.aop.exception;

/**
 * @author Ivanov Roman
 */
public class CustopAopException extends Exception{

    public CustopAopException(String message) {
        super(message);
    }

    public CustopAopException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustopAopException(Throwable cause) {
        super(cause);
    }

    protected CustopAopException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
