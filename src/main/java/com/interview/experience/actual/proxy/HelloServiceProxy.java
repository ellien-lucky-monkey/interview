package com.interview.experience.actual.proxy;

public class HelloServiceProxy implements IHelloService {

    private IHelloService helloService;

    public HelloServiceProxy(IHelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void sayHello() {
        System.out.println("Before say hello...");
        helloService.sayHello();
        System.out.println("After say hello...");
    }
}
