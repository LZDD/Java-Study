package com.lzdd.structural;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/10 2:51 下午
 * 装饰器模式
 * 定义：在不改变原有对象结构的前提下，动态给对象添加一些职责。
 * 关键点：继承同一个接口。抽象修饰器是个具体的类。具体的修饰器重写父类的方法。
 * 理解记忆：将原有对象作为构造参数传入具体的装饰器中。
 **/
public class DecoratePattern {

    public static void main(String[] args) {
        Component c = new Component();
        c.operate();

        Decorate1 d = new Decorate1(c);
        d.operate();
    }
}

interface IDecorateComponent{
    void operate();
}

class Component implements IDecorateComponent{
    @Override
    public void operate() {
        System.out.println("不改变的对象");
    }
}

class AbstractDecorate implements IDecorateComponent{
    private IDecorateComponent idc;

    public AbstractDecorate(IDecorateComponent decorateComponent){
        this.idc = decorateComponent;
    }

    public IDecorateComponent getIdc() {
        return idc;
    }

    public void setIdc(IDecorateComponent idc) {
        this.idc = idc;
    }

    @Override
    public void operate() {
        System.out.println("AbstractDecorate 抽象装饰");
        idc.operate();
    }
}

class Decorate1 extends AbstractDecorate{

    public Decorate1(IDecorateComponent iDecorateComponent){
        super(iDecorateComponent);
    }

    @Override
    public void operate() {
        this.addFunction();
        super.operate();
    }

    public void addFunction(){
        System.out.println("添加一些功能");
    }
}