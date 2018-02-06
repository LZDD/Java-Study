package com.lzdd.Javavm;

/**
 * @author Created by fei.tang@hand-china.com on 2018/1/28.
 * @description 内容交易平台
 */
public class Demo01 {

    public static void main(String[] args){

    }
}


class A{
    public static int width = 100;
    static {
        System.out.println("初始化类A");
    }

    public A(){
        System.out.println("类A的无参构造函数");
    }
}