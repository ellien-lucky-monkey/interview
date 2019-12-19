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
     * <p>
     * <p>
     * <p>
     * Java基础知识
     * 集合 List
     * HashMap 底层实现  put操作过程
     * ConcurrentHashMap 底层实现
     * <p>
     * <p>
     * Jdk代理 Cglib代理
     */

    //=========================synchronized=================================================================

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

    //=========================HashMap=================================================================
    /**
     判断当前桶是否为空，空的就需要初始化（resize 中会判断是否进行初始化）。

     根据当前 key 的 hashcode 定位到具体的桶中并判断是否为空，为空表明没有 Hash 冲突就直接在当前位置创建一个新桶即可。

     如果当前桶有值（ Hash 冲突），那么就要比较当前桶中的 key、key 的 hashcode 与写入的 key 是否相等，相等就赋值给 e,在第 8 步的时候会统一进行赋值及返回。

     如果当前桶为红黑树，那就要按照红黑树的方式写入数据。

     如果是个链表，就需要将当前的 key、value 封装成一个新节点写入到当前桶的后面（形成链表）。

     接着判断当前链表的大小是否大于预设的阈值，大于时就要转换为红黑树。

     如果在遍历过程中找到 key 相同时直接退出遍历。

     如果 e != null 就相当于存在相同的 key,那就需要将值覆盖。

     最后判断是否需要进行扩容。
     */





    /**
     * Springboot原理 自动装配原理
     * Spring原理
     */

    /**
     * Mysql索引 查询优化  参考面试文章 https://www.cnblogs.com/williamjie/p/11187470.html
     * 分页查询优化
     * 慢查询优化思路
     */


    /**
     * 分布式 dubbo SpringCloud组件
     * RPC
     *
     *
     */

    /**
     * Redis数据结构   {String <SDS动态字符串>}             【String Hash List Set Zset】
     * Redis集群
     * Kafka
     * Zookeeper
     */


    private static volatile int a;
    private static ConcurrentHashMap<String, Object> cache;


}

/**
 * 算法
 */


/**
 * 设计模式 23中设计模式
 * 单利模式
 * 工厂模式
 * 抽象工厂模式
 * 适配器模式
 * 责任链模式
 * 。。。。。。
 */


//单例模式 饿汉模式双重检查锁

class Singleton {

    private static volatile Singleton singleton = null;


    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();

                }
            }
        }
        return singleton;
    }

}

//静态内部类
class Singleton1 {


    private Singleton1() {
    }

    private static class SingletonHolder {
        private static Singleton1 singleton1 = new Singleton1();

    }

    public static Singleton1 getInstance() {
        return SingletonHolder.singleton1;
    }
}