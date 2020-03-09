package com.lzdd.creational.abstractfactory;

import com.lzdd.creational.abstractfactory.color.ColorFactory;
import com.lzdd.creational.abstractfactory.shape.ShapeFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 16:31
 * @description 内容交易平台
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if("SHAPE".equalsIgnoreCase(choice)){
            return new ShapeFactory();
        }else if("COLOR".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }
        return null;
    }
}
