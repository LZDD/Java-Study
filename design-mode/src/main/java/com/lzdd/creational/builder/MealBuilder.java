package com.lzdd.creational.builder;

/**
 * @author fei.tang@hand-china.com
 * @date 2018/3/27 20:17
 * @description 内容交易平台
 */
public class MealBuilder {
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }
}
