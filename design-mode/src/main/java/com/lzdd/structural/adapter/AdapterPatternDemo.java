package com.lzdd.structural.adapter;

import org.apache.coyote.Adapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/28 17:11
 * @description 内容交易平台
 */
public class AdapterPatternDemo {
    private static final Logger LOG = LoggerFactory.getLogger(AdapterPatternDemo.class);

    public static void main(String[] args){
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","byond the horizon.mp3");
        audioPlayer.play("mp4","alone.mp4");
        audioPlayer.play("vlc","far far awar.vlc");
        audioPlayer.play("avi","mind me.avi");
    }
}
