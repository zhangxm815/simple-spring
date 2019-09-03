package com.example.aop.advice;

import java.lang.reflect.Method;

public class BeforeAdvice implements Advice {

    private Object obj;
    private MethodHolder mh;

    public BeforeAdvice(Object obj, MethodHolder mh) {
        this.obj = obj;
        this.mh = mh;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        mh.invoke();
        return method.invoke(obj, args);
    }
}
