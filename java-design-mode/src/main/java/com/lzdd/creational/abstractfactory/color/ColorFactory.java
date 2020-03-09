package com.lzdd.creational.abstractfactory.color;

import com.lzdd.creational.abstractfactory.AbstractFactory;
import com.lzdd.creational.abstractfactory.shape.Shape;
import org.springframework.util.StringUtils;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 16:27
 * @description 内容交易平台
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        if(StringUtils.isEmpty(colorType)){
            return null;
        }else if("RED".equalsIgnoreCase(colorType)){
            return new Red();
        }else if("GREEN".equalsIgnoreCase(colorType)){
            return new Green();
        }else if("YELLOW".equalsIgnoreCase(colorType)){
            return new Yellow();
        }
        return null;
    }
}
