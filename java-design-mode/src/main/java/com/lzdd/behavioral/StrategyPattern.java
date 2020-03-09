package com.lzdd.behavioral;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/9 3:05 下午
 * 策略模式
 * 定义：定义一系列的算法，并将算法封装起来，使他们可以相互替换，而且算法之间可以独立改变，互不影响。
 * 关键点：上下文context拥有所有算法，可以通过key获取具体算法
 * 理解记忆：上下文context拥有所有算法
 **/
public class StrategyPattern {
    public static void main(String[] args) {
        StrategyContext strategyContext = new StrategyContext();
        strategyContext.strategyMethod("Strategy1");
        strategyContext.strategyMethod("Strategy2");
    }
}

interface IStrategy{
    void strategyMethod();
}

class Strategy1 implements IStrategy{
    @Override
    public void strategyMethod() {
        System.out.println("Strategy1 执行操作");
    }
}

class Strategy2 implements IStrategy{
    @Override
    public void strategyMethod() {
        System.out.println("Strategy2 执行操作");
    }
}


class StrategyContext{
    private Map<String,IStrategy> strategyMap = new HashMap<>();
    public StrategyContext(){
        super();
        strategyMap.put("Strategy1",new Strategy1());
        strategyMap.put("Strategy2",new Strategy2());
    }

    public IStrategy getStrategy(String key){
        return strategyMap.get(key);
    }

    public void strategyMethod(String key){
        getStrategy(key).strategyMethod();
    }
}