package com.lzdd.adal.structure.link;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/13 4:48 下午
 * 双向链表
 **/
public class DLNode {
    private Object element;
    private DLNode pre;
    private DLNode next;

    public Object getElement() {
        return element;
    }
    public void setElement(Object element) {
        this.element = element;
    }
    public DLNode getPre() {
        return pre;
    }
    public void setPre(DLNode pre) {
        this.pre = pre;
    }
    public DLNode getNext() {
        return next;
    }
    public void setNext(DLNode next) {
        this.next = next;
    }
}
