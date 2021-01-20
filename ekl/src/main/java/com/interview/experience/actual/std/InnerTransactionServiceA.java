package com.interview.experience.actual.std;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InnerTransactionServiceA {


    @Transactional(rollbackFor = Exception.class)
    public void innerTransactionMethodA() {
        System.out.println("InnerTransactionServiceA执行");
    }
}
