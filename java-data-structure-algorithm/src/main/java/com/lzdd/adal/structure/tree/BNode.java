package com.lzdd.adal.structure.tree;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/18 8:21 下午
 **/
public class BNode {
    private BNode parent,lChild,rChild;
    private int age;
    private String name;

    public BNode getParent() {
        return parent;
    }

    public void setParent(BNode parent) {
        this.parent = parent;
    }

    public BNode getlChild() {
        return lChild;
    }

    public void setlChild(BNode lChild) {
        this.lChild = lChild;
    }

    public BNode getrChild() {
        return rChild;
    }

    public void setrChild(BNode rChild) {
        this.rChild = rChild;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
