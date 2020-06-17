package com.interview.experience.actual.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aop2 {

    @Pointcut(value = "@annotation(Asp)")
    public void apo2() {

    }

    @Around(value = "apo2()")
    public Object around(final ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(String.format("Aop2 annotationAsp start 线程%s, 执行annotationAsp方法 hashcode: %s", Thread.currentThread().getName(), "apo2".hashCode()));
        if ("pool-1-thread-2".equals(Thread.currentThread().getName())) {
            throw new RuntimeException("");
        }
        Object proceed = joinPoint.proceed();
        System.out.println("apo2 = " + proceed.toString());
        return proceed;
    }
}
