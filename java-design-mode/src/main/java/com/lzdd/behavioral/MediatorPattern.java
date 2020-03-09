package com.lzdd.behavioral;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/6 3:29 下午
 * 中介者模式
 * 定义：定义一个中介对象来封装对象之间的交互，是原有对象松耦合。
 * 关键点：中介对象的注册和转发。 驱动是对象。
 * 理解记忆：对象的一个方法调用中介的一个方法，中介的方法在调用其他对象的方法。
 **/
public class MediatorPattern {

    public static void main(String[] args) {
        ConcreteMediator me = new ConcreteMediator();
        AbstractColleague c1 = new Colleague1();
        AbstractColleague c2 = new Colleague2();
        me.register(c1);
        me.register(c2);

        c1.send();
        c2.send();
    }

}


interface IMediator{
    void register(AbstractColleague colleague);
    void reply(AbstractColleague colleague);
}

abstract class AbstractColleague {
    private IMediator mediator;

    public IMediator getMediator() {
        return mediator;
    }

    public void setMediator(IMediator mediator){
        this.mediator = mediator;
    }

    public abstract void send();
    public abstract void receive(String msg);
}

class ConcreteMediator implements IMediator{

    List<AbstractColleague> colleagues = Lists.newLinkedList();

    @Override
    public void register(AbstractColleague colleague) {
        if (!colleagues.contains(colleague)){
            colleagues.add(colleague);
            colleague.setMediator(this);
        }
    }

    @Override
    public void reply(AbstractColleague colleague) {
        for (AbstractColleague col : colleagues){
            if (col != colleague){
                col.receive("");
            }
        }
    }
}

class Colleague1 extends AbstractColleague{

    @Override
    public void send() {
        this.getMediator().reply(this);
    }

    @Override
    public void receive(String msg) {
        System.out.println("Colleague1接受到:"+msg);
    }
}

class Colleague2 extends AbstractColleague{

    @Override
    public void send() {
        this.getMediator().reply(this);
    }

    @Override
    public void receive(String msg) {
        System.out.println("Colleague2接受到:"+msg);
    }
}