package com.lzdd.creational.factory;


import org.springframework.util.StringUtils;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 13:55
 * @description 形状工厂类
 */
public class ShapeFactory {
    public static Shape getShape(String shapeType){
        if(StringUtils.isEmpty(shapeType.trim())){
            return null;
        }else if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
