package com.lzdd.structural;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/11 10:47 上午
 * 定义：将一个类的接口转换成客户想要的接口，使那些原本由于接口不兼容不能一起工作的类能一起工作。
 *      分为对象型适配器和结构型适配器。
 * 关键点：提供一个对外的接口。在接口实现的类中调用要适配的方法。
 * 理解记忆：适配器Adapter实现Target接口，并且调用了Adaptee的方法。
 **/
public class AdapterPattern {

    public static void main(String[] args) {

        new AdapterFromCombination(new Adaptee()).request();

        new AdapterFromExtends().getName();
    }
}

interface Target{
    void request();
}

class Adaptee{
    public void getName(){
        System.out.println("适配者方法");
    }
}

/**
 * 对象型聚合。通过聚合方式。
 */
class AdapterFromCombination implements Target{

    private Adaptee adaptee ;

    public AdapterFromCombination(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.getName();
    }
}

/**
 * 结构型聚合。通过继承。
 */
class AdapterFromExtends extends Adaptee implements Target{

    @Override
    public void request() {
        this.getName();
    }
}