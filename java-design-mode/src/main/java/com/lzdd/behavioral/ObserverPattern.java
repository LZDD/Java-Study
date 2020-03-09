package com.lzdd.behavioral;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/6 4:48
 * 定义：当一个对象与多个对象存在一对多的关系时，一个对象的状态发生改变，需要通知到其他对象，并自动更新。
 * 关键点：驱动是 主题对象调用通知方法。
 * 理解记忆：主题对象将观察者聚合，然后通知。
 **/
public  class ObserverPattern {
    public static void main(String[] args) {
        ISubject subject = new Subject();
        subject.add(new Observer1());
        subject.add(new Observer2());
        subject.notifyAllObj();
    }
}

interface IObserver{
    void  response();
}

interface ISubject{
    void add(IObserver observer);
    void remove(IObserver observer);
    void notifyAllObj();
}

class Observer1 implements IObserver{
    @Override
    public void response() {
        System.out.println("Observer1 收到通知");
    }
}

class Observer2 implements IObserver{
    @Override
    public void response() {
        System.out.println("Observer2 收到通知");
    }
}

class Subject implements ISubject{

    List<IObserver> observers = Lists.newLinkedList();

    @Override
    public void add(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
    }

    @Override
    public void notifyAllObj() {
        for (IObserver o : observers){
            o.response();
        }
    }
}