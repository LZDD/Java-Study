package com.lzdd.creational.builder;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 20:02
 * @description 内容交易平台
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 7.5f;
    }
}
