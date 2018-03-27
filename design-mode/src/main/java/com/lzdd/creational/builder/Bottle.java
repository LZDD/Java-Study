package com.lzdd.creational.builder;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 19:51
 * @description 内容交易平台
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
