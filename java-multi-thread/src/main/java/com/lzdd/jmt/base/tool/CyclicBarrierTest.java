package com.lzdd.jmt.base.tool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/11 9:06 下午
 **/
public class CyclicBarrierTest {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        final CyclicBarrier barrier = new CyclicBarrier(4);
        for (int i=0;i<3;i++){
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "等待执行,awaitNum=" + barrier.getNumberWaiting());
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + "执行完成,awaitNum=" + barrier.getNumberWaiting());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println(Thread.currentThread().getName() + "等待执行,awaitNum=" + barrier.getNumberWaiting());
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "等待执行,awaitNum=" + barrier.getNumberWaiting());
        barrier.await();
        System.out.println(Thread.currentThread().getName() + "执行完成,awaitNum=" + barrier.getNumberWaiting());

    }
}
