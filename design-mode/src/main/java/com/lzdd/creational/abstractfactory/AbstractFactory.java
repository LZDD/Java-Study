package com.lzdd.creational.abstractfactory;

import com.lzdd.creational.abstractfactory.color.Color;
import com.lzdd.creational.abstractfactory.shape.Shape;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 16:18
 * @description 内容交易平台
 */
public abstract class AbstractFactory {
    public abstract Shape getShape(String shapeType);
    public abstract Color getColor(String colorType);
}
