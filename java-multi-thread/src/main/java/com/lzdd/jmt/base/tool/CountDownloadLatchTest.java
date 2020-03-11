package com.lzdd.jmt.base.tool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/11 8:57 下午
 **/
public class CountDownloadLatchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        for (int i=0; i<2;i++){
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 开始");
                    TimeUnit.MILLISECONDS.sleep(1000);
                    latch.countDown();
                    System.out.println(Thread.currentThread().getName() + " 结束,countDown=" + latch.getCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println(Thread.currentThread().getName() + "等待countDown="+latch.getCount());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完成");

    }


}
