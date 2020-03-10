package com.lzdd.structural;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/10 11:24 上午
 * 享元模式
 * 定义：运用共享技术有效支持大量细粒度对象的复用。大量减少重复对象的创建。
 * 关键点：将一个对象的状态分为内部状态和外部状态。外部状态通过参数传入。
 * 理解记忆：工厂方法构建共享的对象，非共享通过参数传入。
 **/
public class FlyWeightPattern {
    public static void main(String[] args) {
        IFlyWeight f1 = FlyWeightFactory.get("1");
        IFlyWeight f2 = FlyWeightFactory.get("2");

        f1.operate(new UnSharedFlyWeight("a"));
        f1.operate(new UnSharedFlyWeight("b"));
        f1.operate(new UnSharedFlyWeight("c"));
        f1.operate(new UnSharedFlyWeight("d"));

        f2.operate(new UnSharedFlyWeight("a"));
        f2.operate(new UnSharedFlyWeight("b"));
        f2.operate(new UnSharedFlyWeight("c"));
        f2.operate(new UnSharedFlyWeight("d"));

    }

}

interface IFlyWeight{
    void operate(UnSharedFlyWeight unSharedFlyWeight);
}

class FlyWeight implements IFlyWeight{
    private String name;

    public FlyWeight(String name){
        this.name = name;
        System.out.println("享元类" + name + "被创建");
    }

    @Override
    public void operate(UnSharedFlyWeight unSharedFlyWeight) {
        System.out.println("非享元类:" + unSharedFlyWeight.getHobby());
    }
}


class UnSharedFlyWeight{
    private String hobby;

    public UnSharedFlyWeight(String hobby) {
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}


class FlyWeightFactory{
    private static Map<String,IFlyWeight> flyWeightMap = new HashMap<>();
    public static IFlyWeight get(String name){
        if (flyWeightMap.get(name) != null){
            return flyWeightMap.get(name);
        }
        IFlyWeight flyWeight = new FlyWeight(name);
        flyWeightMap.put(name,flyWeight);
        return flyWeight;
    }
}