package com.example.ioc;

import com.example.ioc.exception.RegisterBeanException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class Register {
    /**
     * name和bean对象的缓存
     **/
    private Map<String, Object> beanMap = new ConcurrentHashMap<String, Object>(64);

    private Register() {
    }

    private static class RigisterHolder {
        private static final Register REGISTER = new Register();
    }

    public static final Register getInstance() {
        return RigisterHolder.REGISTER;
    }

    public void registerBeans(String name, Object bean) throws RegisterBeanException {

        if (beanMap.containsKey(name)) {
            throw new RegisterBeanException("注册bean异常，不允许覆盖");
        }
        synchronized (this.beanMap) {
            if (!beanMap.containsKey(name)) {
                beanMap.put(name, bean);
            }
        }
    }

    public Object getBean(String name) {
        return beanMap.get(name);
    }
}
