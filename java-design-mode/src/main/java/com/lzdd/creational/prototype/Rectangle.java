package com.lzdd.creational.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/28 10:56
 * @description 内容交易平台
 */
public class Rectangle extends Shape{
    private static final Logger LOG = LoggerFactory.getLogger(Rectangle.class);
    public Rectangle(){
        type = "Rectangle";
    }
    @Override
    void draw() {
        LOG.debug("Inside Rectangle::draw() method.");
    }
}
