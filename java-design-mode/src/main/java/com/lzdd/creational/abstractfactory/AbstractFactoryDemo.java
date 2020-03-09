package com.lzdd.creational.abstractfactory;

import com.lzdd.creational.abstractfactory.color.Color;
import com.lzdd.creational.abstractfactory.shape.Shape;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 16:29
 * @description 内容交易平台
 */
public class AbstractFactoryDemo {
    public static void main(String[] args){
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();

        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color red = colorFactory.getColor("RED");
        red.fill();

        Color green = colorFactory.getColor("GREEN");
        green.fill();

        Color yellow = colorFactory.getColor("YELLOW");
        yellow.fill();


    }
}
