package com.example.ioc;

import org.junit.Test;

public class TestIOC {
    @Test
    public void testBean(){
        BeanFactory bf = new XmlBeanFactory("test.xml");
        Hello hello = (Hello) bf.getBean("hello");
        hello.sayHello();
    }
}
