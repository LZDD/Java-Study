package com.lzdd.domain;

import java.util.*;

/**
 * @author Created by fei.tang@hand-china.com on 2018/2/5.
 * @description 内容交易平台
 */
public class Object2TreeJsonUtilTest {
    public static void main(String[] args){
        List<Template> templates = new ArrayList<Template>(){{
            add( new Template("1","品牌方","影视","电视剧"));
            add(new Template("2","品牌方","影视","电影"));
            add(new Template("3","品牌方","影视","动画"));
            add(new Template("4","品牌方","体育","足球"));
            add(new Template("5","品牌方","体育","篮球"));
        }};
        System.out.println(Object2TreeJsonUtil.generatorJson(templates));
    }




}
