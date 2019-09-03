package com.example.aop.advice;

import java.lang.reflect.Method;

public class AfterAdvice implements Advice {

    private Object obj;
    private MethodHolder mh;

    public AfterAdvice(Object obj, MethodHolder mh) {
        this.obj = obj;
        this.mh = mh;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(obj, args);
        mh.invoke();
        return result;
    }
}
