package com.interview.experience.actual.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aop1 {

    @Pointcut(value = "execution(* com.interview.experience.actual.aop.AopService.initAop(..))")
    public void apo1() {

    }

    @Around(value = "apo1()")
    public Object around(final ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(String.format("Aop1 initAop start 线程%s, 执行initAop方法 hashcode: %s", Thread.currentThread().getName(), "apo1".hashCode()));
        Object proceed = joinPoint.proceed();
        System.out.println("apo1 = " + proceed.toString());
        return proceed;
    }
}
