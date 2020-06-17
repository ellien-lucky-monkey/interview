package com.interview.experience.actual.aop;

import org.springframework.stereotype.Service;

@Service
public class AopService {

    @Asp
    public Object initAop() {
        System.out.println(String.format("线程%s, 执行aop方法", Thread.currentThread().getName()));
        return 1;
    }
}
