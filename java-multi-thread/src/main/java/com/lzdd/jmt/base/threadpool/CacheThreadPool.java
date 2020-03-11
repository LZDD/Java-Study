package com.lzdd.jmt.base.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/11 5:21 下午
 **/
public class CacheThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i=0;i<12;i++){
            service.submit( () -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        TimeUnit.SECONDS.sleep(50);
        System.out.println("50秒后线程池状态" + service);

        TimeUnit.SECONDS.sleep(20);
        System.out.println("61秒后线程池状态" + service);
    }
}
