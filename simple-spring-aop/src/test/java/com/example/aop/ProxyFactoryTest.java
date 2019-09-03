package com.example.aop;

import com.example.aop.advice.BeforeAdvice;
import com.example.aop.proxy.SpringProxyFatory;
import com.example.aop.supper.MethodHolder;
import org.junit.Test;

public class ProxyFactoryTest {
    @Test
    public void getProxy(){
        MethodHolder mh = () -> System.out.println("say");
        Hello hello = new HelloImpl();
        SpringProxyFatory<Hello> pf = new SpringProxyFatory(hello,new BeforeAdvice(hello,mh));
        pf.getProxy().sayHello();
    }
}
