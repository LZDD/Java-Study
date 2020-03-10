package com.lzdd.jmt.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/9 4:07 下午
 **/
public class CreateThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1、实现Runnable接口
        ThreadFromRunnable threadFromRunnable = new ThreadFromRunnable();
        Thread thread = new Thread(threadFromRunnable);
        thread.start();

        // 2、继承Thread
        new ThreadExtendsThread().start();

        // 3、Future和Callable
        FutureTask<Integer> task = new FutureTask<>(new ThreadFromCallable());
        new Thread(task).start();
        System.out.println(task.get());

    }
}

class ThreadFromRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("ThreadFromRunnable.....");
    }
}

class ThreadExtendsThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread extends....");
    }
}

class ThreadFromCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("ThreadFromCallable...");
        return 345;
    }
}