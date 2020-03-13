package com.lzdd.adal.structure.stack;

import com.lzdd.adal.structure.link.DLNode;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/13 6:09 下午
 **/
public class MyLinkedStack<E> implements IStack<E> {
    private DLNode head = new DLNode();

    @Override
    public void push(E e) {
        DLNode newNode = new DLNode();
        newNode.setElement(e);
        newNode.setNext(head.getNext());
        head.setNext(newNode);
    }

    @Override
    public E pop() {
        E e = (E) head.getElement();
        head.setNext(head.getNext());
        return e;
    }

    @Override
    public E peek() {
        return (E) head.getElement();
    }

    @Override
    public boolean empty() {
        return head.getNext() == null;
    }
}
