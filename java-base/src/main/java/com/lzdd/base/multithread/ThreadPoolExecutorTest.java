package com.lzdd.base.multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/6 11:48 上午
 **/
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,4, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));

        executor.submit(new Thread());
    }
}
