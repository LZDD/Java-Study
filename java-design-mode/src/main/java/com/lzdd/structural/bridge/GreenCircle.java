package com.lzdd.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/29 11:35
 * @description 内容交易平台
 */
public class GreenCircle implements DrawApi {
    private static final Logger LOG = LoggerFactory.getLogger(GreenCircle.class);
    @Override
    public void drawCircle(int radius, int x, int y) {
        LOG.debug("GreenCircle::drawCircle[radius="+radius+",x="+x+",y="+y+"]");
    }
}
