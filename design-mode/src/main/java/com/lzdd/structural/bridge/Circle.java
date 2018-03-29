package com.lzdd.structural.bridge;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/29 16:56
 * @description 内容交易平台
 */
public class Circle extends Shape {
    private int x,y,radius;
    public Circle(int x,int y,int radius,DrawApi drawApi){
        super(drawApi);
    }
    @Override
    public void draw() {
        drawApi.drawCircle(radius,x,y);
    }
}
