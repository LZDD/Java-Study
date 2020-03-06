package com.lzdd.datastructurealgorithm.algorithm;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author daniel.fei@oyohotels.cn
 * @Time 2020/3/5 8:41 下午
 **/
public class BubblingSorted {

    public static void main(String[] args) {
        List<Long> longs = Lists.newArrayList();
        longs.add(43L);
        longs.add(4L);
        longs.add(3L);
        longs.add(22L);
        longs.add(8L);
        BubblingSorted.sort(longs);
        System.out.println(JSON.toJSONString(longs));
    }

    public static void sort(List<Long> list){
        if (list.size() < 2){
            return;
        }
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.size() -i -1 ; j++){
                if (list.get(j).compareTo(list.get(j+1)) > 0){
                    long temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
    }
}
