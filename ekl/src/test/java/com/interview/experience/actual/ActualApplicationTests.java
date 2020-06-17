package com.interview.experience.actual;

import com.interview.experience.actual.aop.AopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ActualApplication.class)
public class ActualApplicationTests {

    @Autowired
    private AopService aopService;

    @Test
    public void contextLoads() {
    }


    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Test
    public void aopService() {

        ExecutorService service = Executors.newFixedThreadPool(3);
        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAnswer = new CountDownLatch(2);
        for (int i = 0; i < 2; i++) {
            int andIncrement = atomicInteger.getAndIncrement();
            System.out.println(String.format("线程:%s、随机数为:%s", Thread.currentThread().getName(), andIncrement));
            Runnable runnable = () -> {
                try {
                    cdOrder.await(); //
                    aopService.initAop();
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println(String
                            .format("线程%s, 调用成功", Thread.currentThread().getName()));
                } catch (Exception e) {
                    System.out.println(String
                            .format("线程%s, 调用失败", Thread.currentThread().getName()));
                    e.printStackTrace();
                } finally {
                    cdAnswer.countDown(); //任务执行完毕
                }
            };
            service.execute(runnable);//为线程池添加任务
        }

        try {
            Thread.sleep((long) (Math.random() * 10000));
            cdOrder.countDown(); // 开始执行线程
            cdAnswer.await();// 等待
            System.out.println("并发更新任务状态结束");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void aopService_single() {
        aopService.initAop();
    }

}
