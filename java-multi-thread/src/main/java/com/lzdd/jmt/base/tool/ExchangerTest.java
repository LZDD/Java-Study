package com.lzdd.jmt.base.tool;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/11 9:35 下午
 **/
public class ExchangerTest {
    public static void main(String[] args) throws InterruptedException {
        final Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread(() -> {
            int i = 10;
            try {
                System.out.println(Thread.currentThread().getName() + " 交换之前的数据=" + i);
                i = exchanger.exchange(i);
                System.out.println(Thread.currentThread().getName() + " 交换之后的数据=" + i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            int i = 20;
            try {
                System.out.println(Thread.currentThread().getName() + " 交换之前的数据=" + i);
                TimeUnit.MILLISECONDS.sleep(1000);
                i = exchanger.exchange(i);
                System.out.println(Thread.currentThread().getName() + " 交换之后的数据=" + i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.MILLISECONDS.sleep(2000);

    }
}
