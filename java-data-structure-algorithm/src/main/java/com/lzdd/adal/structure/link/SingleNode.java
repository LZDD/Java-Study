package com.lzdd.adal.structure.link;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/13 4:47 下午
 * 单向链表
 **/
public class SingleNode{
    private Object element;
    private SingleNode next;

    public Object getElement() {
        return element;
    }
    public void setElement(Object element) {
        this.element = element;
    }
    public SingleNode getNext() {
        return next;
    }
    public void setNext(SingleNode next) {
        this.next = next;
    }
}