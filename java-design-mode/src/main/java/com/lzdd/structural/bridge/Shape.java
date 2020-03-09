package com.lzdd.structural.bridge;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/29 11:38
 * @description 内容交易平台
 */
public abstract class Shape {
    protected DrawApi drawApi;
    protected Shape(DrawApi drawApi){
        this.drawApi = drawApi;
    }
    public abstract void draw();
}
