package com.lzdd.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/28 16:35
 * @description 内容交易平台
 */
public class Mp4Player implements AdvancedMediaPlayer {
    private static final Logger LOG = LoggerFactory.getLogger(Mp4Player.class);

    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        LOG.debug("Playing file name:"+ fileName);
    }
}
