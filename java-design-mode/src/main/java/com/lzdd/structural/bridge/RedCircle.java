package com.lzdd.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/29 11:33
 * @description 内容交易平台
 */
public class RedCircle implements DrawApi{
    private static final Logger LOG = LoggerFactory.getLogger(RedCircle.class);
    @Override
    public void drawCircle(int radius, int x, int y) {
        LOG.debug("RedCircle::drawCircle[radius="+radius+",x="+x+",y="+y+"]");
    }
}
