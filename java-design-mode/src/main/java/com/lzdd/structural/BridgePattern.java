package com.lzdd.structural;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/11 10:34 上午
 * 桥接模式
 * 定义：将抽象和具体实现分离，使他们可以独立变化。用聚合代替继承。
 * 关键点：抽象类Bag具有颜色的引用。
 * 理解记忆：组合关系由客户端负责。
 **/
public class BridgePattern {
    public static void main(String[] args) {
        AbstractBag b1 = new BigBag(new Yellow());
        AbstractBag b2 = new BigBag(new Black());

        AbstractBag b3 = new SmallBag(new Yellow());
        AbstractBag b4 = new SmallBag(new Black());

        b1.getBag();
        b2.getBag();
        b3.getBag();
        b4.getBag();
    }

}

interface IColor{
    String getColor();
}

abstract class AbstractBag{
    protected IColor color;
    public AbstractBag(IColor color){
        this.color = color;
    }

    abstract void getBag();
}

class Yellow implements IColor{
    @Override
    public String getColor() {
        return "黄色";
    }
}

class Black implements IColor{
    @Override
    public String getColor() {
        return "黑色";
    }
}

class BigBag extends AbstractBag{

    public BigBag(IColor color) {
        super(color);
    }

    @Override
    void getBag() {
        System.out.println(color.getColor() + "大包");
    }
}

class SmallBag extends AbstractBag{

    public SmallBag(IColor color) {
        super(color);
    }

    @Override
    void getBag() {
        System.out.println(color.getColor() + "小包");
    }
}