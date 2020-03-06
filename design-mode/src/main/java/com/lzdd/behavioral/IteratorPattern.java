package com.lzdd.behavioral;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author daniel.fei@oyohotels.cn
 * @Time 2020/3/6 3:02 下午
 * 迭代器模式
 * 定义：提供一个对象还顺序访问集合对象的内部数据，而不暴露集合对象的内部表示。
 * 关键点：具体迭代器的实现。 驱动是数据结构对象。
 * 理解记忆：数据结构将内部的数据结构通过参数传给迭代器，迭代器进行遍历。
 **/
public class IteratorPattern {
    public static void main(String[] args) {
        ConcreteAggregator ca = new ConcreteAggregator();
        ca.add("first");
        ca.add("two");
        ca.add("3333");
        Iterator iterator = ca.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}


interface Iterator{
    Object first();
    boolean hasNext();
    Object next();
}

interface IAggregator{
    void add(Object o);
    void remove(Object o);
    Iterator getIterator();
}


class ConcreteIterator implements Iterator{

    private transient volatile int index = -1;

    List<Object> data = Lists.newLinkedList();

    public ConcreteIterator(List<Object> data){
        this.data = data;
    }

    @Override
    public Object first() {
        return data.get(0);
    }

    @Override
    public boolean hasNext() {
        if (index < data.size() - 1){
            return true;
        }

        return false;
    }

    @Override
    public Object next() {
        return data.get(++index);
    }
}

class ConcreteAggregator implements IAggregator{

    private List<Object> datas = Lists.newLinkedList();

    @Override
    public void add(Object o) {
        datas.add(o);
    }

    @Override
    public void remove(Object o) {

    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(datas);
    }
}