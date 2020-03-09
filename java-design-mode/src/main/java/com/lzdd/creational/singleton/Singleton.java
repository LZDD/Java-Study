package com.lzdd.creational.singleton;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/21 9:28
 * @description 单例模式，确保一个类只有一个实例，并且该实例在内存中自己实例化，可以直接获得。
 */
public class Singleton {
    //在内存中实例化唯一的实例
    private static final Singleton singleton = new Singleton();
    //限制产生多个对象
    private Singleton(){};
    //获取该实例
    public Singleton getSingleton(){
        return singleton;
    }

    //处理其他逻辑
    public static void doSomething(){};
}
