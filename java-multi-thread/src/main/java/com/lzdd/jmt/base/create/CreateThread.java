package com.lzdd.jmt.base.create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/9 4:07 下午
 **/
public class CreateThread {
    public static void main(String[] args) {
        ThreadFromRunnable threadFromRunnable = new ThreadFromRunnable();
        Thread thread = new Thread(threadFromRunnable);
        thread.start();

        new Thread1().start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名构造");
            }
        }).start();

        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        }.start();

        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });
        new Thread(task).start();
    }
}

class ThreadFromRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("ThreadFromRunnable.....");
    }
}

class Thread1 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("Thread1....");
    }
}
