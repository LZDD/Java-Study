package com.lzdd.creational.prototype;

import java.util.Hashtable;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/28 11:04
 * @description 内容交易平台
 */
public class ShapeCache {
    public static Hashtable<String,Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String id){
        Shape shapeCache = shapeMap.get(id);
        return (Shape) shapeCache.clone();
    }

    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapeMap.put(rectangle.getId(),rectangle);

        Square square = new Square();
        square.setId("3");
        shapeMap.put(square.getId(),square);
    }
}
