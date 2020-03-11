package com.lzdd.jmt.base.tool;

import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/11 9:15 下午
 **/
public class SemaphoreTest {
    public static void main(String[] args) throws IOException {
        final Semaphore semaphore = new Semaphore(5);
        for (int i=0;i<10;i++){
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "获取一个资源");
                    TimeUnit.MILLISECONDS.sleep(200);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "释放一个资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.in.read();
    }
}
