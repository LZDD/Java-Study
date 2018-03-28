package com.lzdd.creational.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/28 13:34
 * @description 内容交易平台
 */
public class ProtoTypeDemo {

    private static final Logger LOG = LoggerFactory.getLogger(ProtoTypeDemo.class);

    public static void main(String[] args){
        long startInit = System.currentTimeMillis();
        ShapeCache.loadCache();
        long endInit = System.currentTimeMillis();
        LOG.debug("初始化花费时间:"+(endInit-startInit));

        Shape clonedShape1 = ShapeCache.getShape("1");
        LOG.debug("shape:"+clonedShape1.getType());

        Shape clonedShape2 = ShapeCache.getShape("2");
        LOG.debug("shape:"+clonedShape2.getType());

        Shape clonedShape3 = ShapeCache.getShape("3");
        LOG.debug("shape:"+clonedShape3.getType());
        long endInvoke = System.currentTimeMillis();
        LOG.debug("调用花费的时间:"+(endInvoke-endInit));
    }

}
