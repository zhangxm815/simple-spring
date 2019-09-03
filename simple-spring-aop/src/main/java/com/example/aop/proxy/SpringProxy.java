package com.example.aop.proxy;

import com.example.aop.advice.Advice;

import java.lang.reflect.Proxy;

@Deprecated
public class SpringProxy {

    public static Object getProxy(Object bean, Advice advice) {
        return Proxy.newProxyInstance(SpringProxy.class.getClassLoader(), bean.getClass().getInterfaces(), advice);

    }
}
