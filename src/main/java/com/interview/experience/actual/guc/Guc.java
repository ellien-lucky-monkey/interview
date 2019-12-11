package com.interview.experience.actual.guc;

import java.util.concurrent.ConcurrentHashMap;

public class Guc {

    /**
     * GUC包 locks
     * AbstractQueuedSynchronizer AQS框架
     * <p>
     * 线程池
     * synchronized 关键字
     * volatile 关键字
     * atomic CAS原子操作类
     * gc 垃圾收集
     *
     *
     *
     * Java基础知识
     * 集合 List
     * HashMap 底层实现  put操作过程
     * ConcurrentHashMap 底层实现
     *
     *
     * Jdk代理 Cglib代理
     */


    //1 synchronized的三种应用方式
    //修饰实例方法 -> 锁的对象是对象实例
    static int i = 0;

    public synchronized void increase() {
        i++;
    }

    //修饰静态方法 -> 锁的对象是类实例
    public static synchronized void StaticIncrease() {
        i++;
    }

    // 修饰代码块
    //锁是当前实例对象
    public void syncThis() {
        synchronized (this) {
            i++;
        }
    }

    //锁是class对象
    public void syncClass() {
        synchronized (Guc.class) {
            i++;
        }
    }


    /**
     * Springboot原理 自动装配原理
     * Spring原理
     */

    /**
     * Mysql索引 查询优化
     * 分页查询优化
     * 慢查询优化思路
     */

    /**
     * 设计模式 23中设计模式
     * 单利模式
     * 工厂模式
     * 抽象工厂模式
     * 适配器模式
     * 责任链模式
     * 。。。。。。
     *
     */


    /**
     * 分布式 dubbo SpringCloud组件
     * RPC
     *
     *
     */

    /**
     * Redis数据结构
     * Redis集群
     * Kafka
     * Zookeeper
     */


    private static volatile int a;
    private static ConcurrentHashMap<String, Object> cache;


    /**
     * 算法
     */

}
