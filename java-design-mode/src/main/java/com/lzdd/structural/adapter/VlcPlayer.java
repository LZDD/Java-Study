package com.lzdd.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/28 16:33
 * @description 内容交易平台
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    private static final Logger LOG = LoggerFactory.getLogger(VlcPlayer.class);
    @Override
    public void playVlc(String fileName) {
        LOG.debug("Playing vlc file Name:"+fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
