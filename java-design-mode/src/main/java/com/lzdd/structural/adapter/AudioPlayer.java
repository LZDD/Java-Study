package com.lzdd.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/28 16:57
 * @description 内容交易平台
 */
public class AudioPlayer implements MediaPlayer {
    private static final Logger LOG = LoggerFactory.getLogger(AudioPlayer.class);
    MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String fileName) {
        //播放mp3音乐文件的内置支持
        if(audioType.equalsIgnoreCase("mp3")){
            LOG.debug("Playing mp3 file name:"+fileName);
        }
        //mediaAdapter提供播放其他文件格式的支持
        else if(audioType.equalsIgnoreCase("vlc")||
                audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);
        }else {
            LOG.debug("Invalid media."+audioType+" format not supported");
        }
    }
}
