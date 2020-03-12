package com.lzdd.creational;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/12 11:57 上午
 * 定义：构建同一等级的产品。允许对象的构建延迟到子类中。
 * 关键点：具体的对象创建延迟到子类中。
 * 理解记忆：工厂持有产品的接口。
 **/
public class FactoryMethodPattern {
    public static void main(String[] args) {
        ITvTwo tv1 = new Tv1Factory().newInstance();
        tv1.show();

        ITvTwo tv2 = new Tv2Factory().newInstance();
        tv2.show();
    }
}

interface ITvTwo{
    void show();
}

class Tv1 implements ITvTwo{
    @Override
    public void show() {
        System.out.println("Tv1");
    }
}

class Tv2 implements ITvTwo{
    @Override
    public void show() {
        System.out.println("Tv2");
    }
}

interface IFactory{
    ITvTwo newInstance();
}

class Tv1Factory implements IFactory{

    @Override
    public ITvTwo newInstance() {
        return new Tv1();
    }
}

class Tv2Factory implements IFactory{

    @Override
    public ITvTwo newInstance() {
        return new Tv2();
    }
}