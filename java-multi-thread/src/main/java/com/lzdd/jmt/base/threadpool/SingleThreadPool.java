package com.lzdd.jmt.base.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/11 5:18 下午
 **/
public class SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i=0;i<6;i++){
            service.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            })   ;
        }
    }
}
