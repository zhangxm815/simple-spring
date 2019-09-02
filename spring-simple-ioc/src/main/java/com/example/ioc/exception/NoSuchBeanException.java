package com.example.ioc.exception;

public class NoSuchBeanException extends BeanException {

    public NoSuchBeanException(String message) {
        super(message);
    }
}
