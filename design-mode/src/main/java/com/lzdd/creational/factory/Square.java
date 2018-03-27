package com.lzdd.creational.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 13:53
 * @description 内容交易平台
 */
public class Square implements Shape{
    private static final Logger LOG = LoggerFactory.getLogger(Square.class);
    @Override
    public void draw() {
        LOG.debug("Inside Square :: method draw().");
    }
}
