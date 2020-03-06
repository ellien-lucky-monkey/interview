package com.interview.experience.actual.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloServiceDynamicProxy implements InvocationHandler{

    // 目标对象
    private Object object;

    public HelloServiceDynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----------JDKProxy before------------");
        Object invoke = method.invoke(object, args);
        System.out.println("-----------JDKProxy after------------");
        return invoke;
    }
}
