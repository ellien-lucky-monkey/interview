package com.interview.experience.actual.std;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class InnerTransactionServiceB {


    @Transactional(rollbackFor = Exception.class)
    public void innerTransactionMethodB() {
        System.out.println("InnerTransactionServiceB执行");

        if (TransactionSynchronizationManager.isSynchronizationActive()) {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    System.out.println("事务提交后InnerTransactionServiceB执行");
                }
            });
        } else {
            System.out.println("直接执行事务提交后InnerTransactionServiceB执行");
        }
    }
}
