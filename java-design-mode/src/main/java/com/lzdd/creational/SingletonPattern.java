package com.lzdd.creational;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/12 12:10 下午
 **/
public class SingletonPattern {
    private static volatile SingletonPattern install = null;

    // 关键
    private SingletonPattern(){super();}

    public static SingletonPattern getInstance(){
        if (install == null){
            install = new SingletonPattern();
        }
        return install;
    }
}