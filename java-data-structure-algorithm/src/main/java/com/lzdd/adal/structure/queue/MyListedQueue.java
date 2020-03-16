package com.lzdd.adal.structure.queue;

import com.lzdd.adal.structure.link.DLNode;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/16 5:23 下午
 **/
public class MyListedQueue<E> implements IQueue<E> {
    private DLNode head ,tail ;
    private int size = 0;

    public MyListedQueue(){
        head = new DLNode();
        tail = new DLNode();
        head.setPre(tail);
        tail.setNext(head);
        size = 0;
    }

    @Override
    public boolean add(E o) {
        DLNode newNode = new DLNode();
        newNode.setElement(o);
        newNode.setPre(head.getPre());
        head.setPre(newNode);
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (getSize() < 1){
            return null;
        }
        DLNode element = tail.getNext();
        tail.setNext(tail.getNext());
        element.setNext(null); // help GC
        return (E) element.getElement();
    }

    @Override
    public E element() {
        if (getSize() < 1){
            return null;
        }
        return (E) tail.getNext().getElement();
    }

    @Override
    public int getSize() {
        return size;
    }
}
