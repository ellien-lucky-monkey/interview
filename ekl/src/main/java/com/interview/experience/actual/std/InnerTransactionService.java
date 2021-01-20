package com.interview.experience.actual.std;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class InnerTransactionService {

    @Resource
    private InnerTransactionServiceA innerTransactionServiceA;
    @Resource
    private InnerTransactionServiceB innerTransactionServiceB;

    @Transactional(rollbackFor = Exception.class)
    public void innerTransactionMethod() {

        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("innerTransactionMethod执行");
                innerTransactionServiceA.innerTransactionMethodA();
                innerTransactionServiceB.innerTransactionMethodB();
            }
        } catch (Exception e) {
            System.out.println("innerTransactionMethod执行异常");
            throw e;
        }
    }
}
