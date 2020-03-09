package com.lzdd.creational.abstractfactory.shape;

import com.lzdd.creational.abstractfactory.AbstractFactory;
import com.lzdd.creational.abstractfactory.color.Color;
import org.springframework.util.StringUtils;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 16:21
 * @description 内容交易平台
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if(StringUtils.isEmpty(shapeType.trim())){
            return null;
        }else if("RECTANGLE".equalsIgnoreCase(shapeType)){
            return new Rectangle();
        }else if("SQUARE".equalsIgnoreCase(shapeType)){
            return new Square();
        }else if("CIRCLE".equalsIgnoreCase(shapeType)){
            return new Circle();
        }
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        return null;
    }
}
