package com.lzdd.jmt.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/12 5:00 下午
 **/
public class LockConditionTest {

}

/**
 * 通过一个有界队列BoundedBuffer来了解Condition的使用方式，该类是一个特殊的队列，
 * 当队列为空时，队列的获取操作将会阻塞当前"拿"线程，直到队列中有新增的元素，当队列已满时，
 * 队列的放入操作将会阻塞"放入"线程，直到队列中出现空位
 */
class BoundBuffer{
    private final Lock lock = new ReentrantLock();
    private final Condition putCondition = lock.newCondition();
    private final Condition takeCondition = lock.newCondition();

    private int putPrt,takePrt,count;
    private Object[] data = new Object[100];

    public void put(Object o) throws InterruptedException {
        lock.lock();
        try {
            // 队列满的时候,阻塞当前放的线程
            while (putPrt == data.length){
                putCondition.await();
            }
            data[putPrt] = o;
            if (++putPrt == data.length) putPrt=0;
            count++;
            // 放入了元素，通知阻塞拿的队列
            takeCondition.notify();
        }finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try{
            // 队列为空，拿队列阻塞
            while (takePrt == 0){
                takeCondition.await();
            }
            Object o = data[takePrt];
            if (++takePrt == data.length) takePrt = 0;
            count--;
            putCondition.notify();
            return o;
        }finally {
            lock.unlock();
        }
    }
}
