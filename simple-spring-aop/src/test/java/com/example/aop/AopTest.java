package com.example.aop;

import com.example.aop.advice.BeforeAdvice;
import com.example.aop.proxy.SpringProxy;
import com.example.aop.advice.MethodHolder;

public class AopTest {
    public static void main(String[] args) {
        MethodHolder mh = () -> System.out.println("say");
        Hello hello = new HelloImpl();
        Hello hello2 = (Hello) SpringProxy.getProxy(hello, new BeforeAdvice(hello, mh));
        hello2.sayHello();

    }
}