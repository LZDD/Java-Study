package com.lzdd.adal.structure.list;

import com.lzdd.adal.structure.link.DLNode;

import java.util.Iterator;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/13 5:32 下午
 **/
public class MyLinkedList<E> implements IList<E> {
    private DLNode head,tail;
    private int size = 0;

    public MyLinkedList(){
        DLNode head = new DLNode();
        DLNode tail = new DLNode();
        head.setNext(tail);
        tail.setPre(head);
    }

    @Override
    public E get(int i) {
        if (i < 0 || i >= size){
            return null;
        }
        DLNode target = head;
        for (int j = 0; j<= i; j++){
            target = target.getNext();
        }
        return (E) target.getElement();
    }

    @Override
    public E set(int i, E e) {
        if (i < 0 || i >= size){
            return null;
        }
        DLNode target = head;
        for (int j = 0; j<= i; j++){
            target = target.getNext();
        }
        E oldValue = (E) target.getElement();
        target.setElement(e);
        return oldValue;
    }

    @Override
    public void add(E e) {
        DLNode dlNode = new DLNode();
        dlNode.setElement(e);
        dlNode.setPre(tail.getPre());
        dlNode.setNext(tail);
        tail.setPre(dlNode);
        size++;
    }

    @Override
    public void remove(int i) {
        if (i < 0 || i >= size){
            return;
        }
        DLNode target = head;
        for (int j = 0; j<= i; j++){
            target = target.getNext();
        }
        target.getPre().setNext(target.getNext());
        target.getNext().setPre(target.getPre());
        size--;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public Iterator<E> listIterator() {
        return null;
    }
}
