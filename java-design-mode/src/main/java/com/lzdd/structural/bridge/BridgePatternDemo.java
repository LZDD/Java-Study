package com.lzdd.structural.bridge;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/29 16:58
 * @description 内容交易平台
 */
public class BridgePatternDemo {
    public static void main(String[] args){
        Shape redCircle = new Circle(100,100,10,new RedCircle());
        Shape greenCircle = new Circle(100,100,10,new GreenCircle());
        redCircle.draw();
        greenCircle.draw();
    }
}
