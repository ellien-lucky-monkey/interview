package com.interview.experience.actual.proxy;

import java.lang.reflect.Proxy;

public class HelloServiceDynamicProxyTest {

    public static void main(String[] args) {
        HelloServiceImpl helloService = new HelloServiceImpl();
        HelloServiceDynamicProxy dynamicProxy = new HelloServiceDynamicProxy(helloService);
        IHelloService iHelloService = (IHelloService) Proxy.newProxyInstance(HelloServiceImpl.class.getClassLoader(), new Class[]{HelloServiceImpl.class}, dynamicProxy);
        iHelloService.sayHello();
    }
}
