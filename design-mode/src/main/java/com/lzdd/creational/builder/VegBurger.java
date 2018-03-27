package com.lzdd.creational.builder;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 19:58
 * @description 内容交易平台
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Ver Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
