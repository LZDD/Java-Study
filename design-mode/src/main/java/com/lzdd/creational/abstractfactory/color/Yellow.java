package com.lzdd.creational.abstractfactory.color;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 16:14
 * @description 内容交易平台
 */
public class Yellow implements Color {
    private static final Logger LOG = LoggerFactory.getLogger(Yellow.class);
    @Override
    public void fill() {
        LOG.debug("Inside Yellow :: fill() method.");
    }
}
