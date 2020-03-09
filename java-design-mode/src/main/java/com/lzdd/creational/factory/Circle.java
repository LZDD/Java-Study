package com.lzdd.creational.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 13:49
 * @description 圆形
 */
public class Circle implements Shape{

    private static final Logger LOG = LoggerFactory.getLogger(Circle.class);
    @Override
    public void draw() {
        LOG.debug("Inside Circle :: method draw().");
    }
}
