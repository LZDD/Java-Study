package com.lzdd.creational.builder;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 19:48
 * @description 实物条目
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();

}
