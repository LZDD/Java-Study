package com.lzdd.jmt.base.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/11 5:02 下午
 **/
public class FixedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        System.out.println("线程池初始状态" + fixedThreadPool);
        for (int i=0;i<6;i++){
            fixedThreadPool.submit(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println("被打断");
                }
            });
        }
        System.out.println("线程池提交任务后状态" + fixedThreadPool);

        // 调用关闭，不会影响正在执行的线程
        fixedThreadPool.shutdown();
        System.out.println("线程是否执行完成："+fixedThreadPool.isTerminated());
        System.out.println("线程池是否执关闭："+fixedThreadPool.isShutdown());
        System.out.println("线程池提交任务后状态" + fixedThreadPool);

        TimeUnit.MILLISECONDS.sleep(5000);

        System.out.println("5秒后线程是否执行完成："+fixedThreadPool.isTerminated());
        System.out.println("5秒后线程池是否执关闭："+fixedThreadPool.isShutdown());
        System.out.println("5秒后线程池提交任务后状态" + fixedThreadPool);
    }


}
