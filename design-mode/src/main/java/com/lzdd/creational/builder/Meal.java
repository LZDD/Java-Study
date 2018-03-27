package com.lzdd.creational.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 20:10
 * @description 内容交易平台
 */
public class Meal {
    private static final Logger LOG = LoggerFactory.getLogger(Meal.class);
    private List<Item> items = new ArrayList<Item>();
    public void addItem(Item item){
        items.add(item);
    }
    public float getCost(){
        float cost = 0.0f;
        for(Item item : items){
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for(Item item : items){
            LOG.debug("name:"+item.name());
            LOG.debug("pack:"+item.packing().pack());
            LOG.debug("price:"+item.price());
        }
    }
}
