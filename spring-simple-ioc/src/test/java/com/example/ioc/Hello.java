package com.example.ioc;

public class Hello {

    private String hello;

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public void sayHello() {
        System.out.println(hello);
        System.out.println(test);
    }
}
