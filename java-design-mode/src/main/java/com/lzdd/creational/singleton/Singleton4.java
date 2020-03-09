package com.lzdd.creational.singleton;


/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/28 9:57
 * @description DCL(double check locking)双加锁，高性能的同时保证线程安全。
 */
public class Singleton4 {
    private static volatile Singleton4  instance = null;

    //单例模式关键所在
    private  Singleton4(){};

    private static Singleton4 getInstance(){
        if(instance == null){
            synchronized (Singleton4.class){
                if(instance == null){
                    return new Singleton4();
                }
            }
        }
        return instance;
    }
}
