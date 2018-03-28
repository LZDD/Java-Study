package com.lzdd.creational.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/28 11:00
 * @description 内容交易平台
 */
public class Square extends Shape {
    private static final Logger LOG = LoggerFactory.getLogger(Square.class);

    public Square(){
        type = "Square";
    }
    @Override
    void draw() {
        LOG.debug("Inside Square::draw() method.");
    }
}
