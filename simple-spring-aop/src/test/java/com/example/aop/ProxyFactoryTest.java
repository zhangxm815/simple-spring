package com.example.aop;

import com.example.aop.advice.AfterAdvice;
import com.example.aop.advice.AroudAdvice;
import com.example.aop.advice.BeforeAdvice;
import com.example.aop.advice.MethodHolder;
import com.example.aop.advice.aroud.AroudMethodHolder;
import com.example.aop.proxy.SpringProxyFatory;
import org.junit.Test;

public class ProxyFactoryTest {
    @Test
    public void getProxy() {
        //前置增强
        System.out.println("----------------------------------后置");
        MethodHolder mh = () -> System.out.println("say");
        Hello hello = new HelloImpl();
        SpringProxyFatory<Hello> pf = new SpringProxyFatory(hello, new BeforeAdvice(hello, mh));
        pf.getProxy().sayHello();
        System.out.println("----------------------------------后置");
        //后置增强
        MethodHolder mh2 = () -> System.out.println("word");
        SpringProxyFatory<Hello> pf2 = new SpringProxyFatory(hello, new AfterAdvice(hello, mh2));
        pf2.getProxy().sayHello();
        System.out.println("----------------------------------环绕");
        AroudMethodHolder amh = new AroudMethodHolder() {
            @Override
            public void before() { System.out.println(System.currentTimeMillis()); }
            @Override
            public void after() { System.out.println(System.currentTimeMillis()); }
        };
        SpringProxyFatory<Hello> pf3 = new SpringProxyFatory(hello, new AroudAdvice(hello,amh));
        pf3.getProxy().sayHello();
    }
}
