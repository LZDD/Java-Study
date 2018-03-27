package com.lzdd.creational.factory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 14:03
 * @description 内容交易平台
 */
public class FactoryPatternsDemo {
    public static void main(String[] args){
        Shape rectangle = ShapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        Shape square = ShapeFactory.getShape("SQUARE");
        square.draw();

        Shape circle = ShapeFactory.getShape("CIRCLE");
        circle.draw();

    }
}
