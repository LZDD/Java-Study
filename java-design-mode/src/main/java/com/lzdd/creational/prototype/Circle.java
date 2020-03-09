package com.lzdd.creational.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/28 11:02
 * @description 内容交易平台
 */
public class Circle extends Shape {
    private static final Logger LOG = LoggerFactory.getLogger(Circle.class);
    public Circle(){
        type = "Circle";
    }
    @Override
    void draw() {
        LOG.debug("Inside Circle::draw() method.");
    }
}
