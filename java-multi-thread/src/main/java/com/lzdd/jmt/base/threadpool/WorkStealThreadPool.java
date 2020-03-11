package com.lzdd.jmt.base.threadpool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/11 7:50 下午
 **/
public class WorkStealThreadPool {
    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newWorkStealingPool(4);
        service.submit(new R(1000L));
        service.submit(new R(2000L));
        service.submit(new R(2000L));
        service.submit(new R(2000L));
        service.submit(new R(2000L));
        System.in.read();

    }
}

class R implements Runnable{
    private Long time;

    public R(Long time){
        this.time = time;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
            System.out.println(time + " : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
