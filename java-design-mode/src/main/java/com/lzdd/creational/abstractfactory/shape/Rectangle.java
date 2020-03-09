package com.lzdd.creational.abstractfactory.shape;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 13:47
 * @description 正方形
 */
public class Rectangle implements Shape {

    private static final Logger LOG = LoggerFactory.getLogger(Rectangle.class);
    @Override
    public void draw() {
        LOG.debug("Inside Rectangle :: method draw().");
    }
}
