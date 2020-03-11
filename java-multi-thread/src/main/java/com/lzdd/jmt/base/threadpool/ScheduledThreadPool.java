package com.lzdd.jmt.base.threadpool;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/11 5:31 下午
 **/
public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        service.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + new Random().nextInt(1000));
        },100,500, TimeUnit.MILLISECONDS);

    }
}
