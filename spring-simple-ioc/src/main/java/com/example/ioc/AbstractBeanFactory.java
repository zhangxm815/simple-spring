package com.example.ioc;

import com.example.ioc.exception.NoSuchBeanException;
import com.example.ioc.util.RegisterUtil;

public abstract class AbstractBeanFactory implements BeanFactory {

    public Object getBean(String name) {
        Register register = RegisterUtil.getRegister();
        Object bean = register.getBean(name);
        if (bean == null) {
            throw new NoSuchBeanException("未定义的bean");
        }
        return bean;
    }
}
