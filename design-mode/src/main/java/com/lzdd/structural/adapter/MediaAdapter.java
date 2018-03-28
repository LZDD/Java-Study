package com.lzdd.structural.adapter;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/28 16:38
 * @description 内容交易平台
 */
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer amp;

    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            amp = new VlcPlayer();
        }else if(audioType.equalsIgnoreCase("mp4")){
            amp = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            amp.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            amp.playMp4(fileName);
        }
    }
}
