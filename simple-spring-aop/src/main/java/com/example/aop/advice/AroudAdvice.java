package com.example.aop.advice;

import com.example.aop.advice.aroud.AroudMethodHolder;

import java.lang.reflect.Method;

public class AroudAdvice implements Advice {

    private Object target;
    private AroudMethodHolder amh;

    public AroudAdvice(Object target, AroudMethodHolder amh) {
        this.target = target;
        this.amh = amh;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        amh.before();
        Object result = method.invoke(target, args);
        amh.after();
        return result;
    }


}
