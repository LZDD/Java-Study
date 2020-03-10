package com.lzdd.structural;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/10 12:00 下午
 * 组合模式，又称部分-整体模式
 * 定义：将对象组装成树状结构的模式，使访问一个对象或一组对象具有统一的方式。
 * 关键点：叶子节点的operate方法实现具体的操作，树干结点operate方法是遍历子结点。
 * 理解记忆：叶子节点和树干结点的都实现了同一个类。
 **/
public class ComponentPattern {

    public static void main(String[] args) {
        Composite c1 = new Composite("c1");
        Leaf l1 = new Leaf("l1");
        Composite c2 = new Composite("c2");
        Leaf l2 = new Leaf("l2");
        Leaf l3 = new Leaf("l3");

        c1.add(l1);
        c1.add(c2);
        c2.add(l2);
        c2.add(l3);

        c1.operate();
    }
}

interface IComponent{
    void operate();
}

class Leaf implements IComponent{

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void operate() {
        System.out.println("叶子节点" + name + "被访问");
    }
}

class Composite implements IComponent{
    private List<IComponent> children = new LinkedList<>();

    private String name;

    public Composite(String name){
        this.name = name;
    }

    public List<IComponent> getChilds() {
        return children;
    }

    public void setChilds(List<IComponent> childs) {
        this.children = childs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(IComponent component){
        this.children.add(component);
    }

    public void remove(IComponent component){
        // TODO: 2020/3/10
    }

    @Override
    public void operate() {
        System.out.println("树干结点" + name + "被访问");
        for (IComponent c : children){
            c.operate();
        }
    }
}