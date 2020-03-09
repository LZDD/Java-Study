package com.lzdd.datastructurealgorithm.algorithm;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/5 8:57 下午
 **/
public class Reverse {

    public static void main(String[] args) {
        Long[] longs = new Long[5];
        longs[0] = 43L;
        longs[1] = 4L;
        longs[2] = 3L;
        longs[3] = 22L;
        longs[4] = 8L;
        System.out.println(JSON.toJSONString(longs));
        Reverse.reverseRecursive(longs,0,longs.length -1);
        System.out.println(JSON.toJSONString(longs));
        Reverse.reverseArray(longs,0,longs.length -1);
        System.out.println(JSON.toJSONString(longs));
    }

    public static void reverseRecursive(Object[] objs,int lo,int hi){
        if (lo < hi){
            Object temp = objs[lo];
            objs[lo] = objs[hi];
            objs[hi] = temp;
            reverseRecursive(objs,lo + 1,hi - 1);
        }
    }

    public static void reverseArray(Object[] objs,int lo,int hi){
        while (lo < hi){
            Object temp = objs[lo];
            objs[lo] = objs[hi];
            objs[hi] = temp;
            lo++;
            hi--;
        }
    }
}
