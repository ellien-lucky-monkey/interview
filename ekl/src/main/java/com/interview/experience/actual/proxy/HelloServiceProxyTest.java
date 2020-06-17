package com.interview.experience.actual.proxy;

public class HelloServiceProxyTest {
    public static void main(String[] args) {
        IHelloService helloService = new HelloServiceImpl();
        HelloServiceProxy proxy = new HelloServiceProxy(helloService);
        proxy.sayHello();
    }
}
