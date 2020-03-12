package com.lzdd.creational;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/12 11:30 上午
 * 抽象工厂模式
 * 定义：为访问这提供一组相关或依赖的接口，且访问类不需要指定所要产品的具体类就可以产出一族产品的不同等级的产品。
 * 关键点：产出一族不同等级的产品。工厂接口提供生产不同等级的接口。产品接口定义不同的产品。
 * 理解记忆：具体的工厂方法调用不同等级的产品。
 **/
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        IAbstractFactory hairFactory = new HairFactory();
        hairFactory.getAirConditioner().show();
        hairFactory.getTv().getInfo();

        IAbstractFactory tclFactory = new TclFactory();
        tclFactory.getAirConditioner().show();
        tclFactory.getTv().getInfo();
    }
}

// 空调
interface IAirConditioner{
    void show();
}

// 海尔空调
class HairAirConditioner implements IAirConditioner{
    @Override
    public void show() {
        System.out.println("海尔空调");
    }
}

// TCL空调
class TclAirConditioner implements IAirConditioner{
    @Override
    public void show() {
        System.out.println("TCL空调");
    }
}

interface ITv{
    void getInfo();
}

// 海尔电视
class HairTv implements ITv{
    @Override
    public void getInfo() {
        System.out.println("海尔电视");
    }
}
// Tcl电视
class TclTv implements ITv{
    @Override
    public void getInfo() {
        System.out.println("Tcl电视");
    }
}

interface IAbstractFactory{
    IAirConditioner getAirConditioner();
    ITv getTv();
}

class HairFactory implements IAbstractFactory{
    @Override
    public IAirConditioner getAirConditioner() {
        return new HairAirConditioner();
    }

    @Override
    public ITv getTv() {
        return new HairTv();
    }
}

class TclFactory implements IAbstractFactory{
    @Override
    public IAirConditioner getAirConditioner() {
        return new TclAirConditioner();
    }

    @Override
    public ITv getTv() {
        return new TclTv();
    }
}
