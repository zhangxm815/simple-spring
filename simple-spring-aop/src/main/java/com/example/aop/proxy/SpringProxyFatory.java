package com.example.aop.proxy;

import com.example.aop.advice.Advice;

import java.lang.reflect.Proxy;

public class SpringProxyFatory<T> {

    private Object target;
    private Advice advice;

    public SpringProxyFatory(Object target, Advice advice) {
        this.target = target;
        this.advice = advice;
    }

    public T getProxy() {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), advice);
    }


}
