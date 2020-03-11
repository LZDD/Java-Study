package com.lzdd.jmt.base.threadpool;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/11 8:02 下午
 **/
public class ForkJoinThreadPool {

    static int[] nums = new int[10000];
    static final int MAX_NUM = 500;
    static Random random = new Random();
    static {
        for (int i=0;i<nums.length;i++){
            nums[i] = random.nextInt(100);
        }
        System.out.println(Arrays.stream(nums).sum());
    }

    static class AddTask extends RecursiveTask<Long>{
        private int start,end;

        public AddTask(int start,int end){
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute(){
            Long sum = 0L;
            if (end - start < MAX_NUM){
                for (int i = start; i < end; i++){
                    sum += nums[i];
                }
                return sum;
            }else {
                int middle = (start + end) / 2;
                AddTask addTask1 = new AddTask(start,middle);
                AddTask addTask2 = new AddTask(middle,end);
                addTask1.fork();
                addTask2.fork();
                return addTask1.join() + addTask2.join();
            }
        }
    }


    public static void main(String[] args) {
        ForkJoinPool threadPool = new ForkJoinPool();
        AddTask task = new AddTask(0,nums.length);
        threadPool.invoke(task);
        long result = task.join();
        System.out.println(result);

        threadPool.shutdown();
    }
}


