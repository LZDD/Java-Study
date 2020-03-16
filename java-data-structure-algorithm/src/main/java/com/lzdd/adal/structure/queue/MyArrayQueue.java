package com.lzdd.adal.structure.queue;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/16 4:02 下午
 **/
public class MyArrayQueue<E> implements IQueue<E> {
    private Object[] elements;
    private static int CAPACITY = 10;
    private int capacity;
    private int head = 0,tail = 0;

    public MyArrayQueue(){
        this.elements = new Object[CAPACITY];
        this.capacity = this.CAPACITY;
    }

    public MyArrayQueue(int capacity){
        elements = new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public boolean add(E o) {
        if (getSize() == this.capacity){
            return false;
        }
        elements[tail] = o;
        tail = ++tail % capacity;
        return true;
    }

    @Override
    public E remove() {
        if (getSize() == 0){
            return null;
        }
        E e = (E) elements[head];
        elements[head] = null;
        head = ++head % capacity;
        return e;
    }

    @Override
    public E element() {
        if (head == tail){
            return null;
        }
        return (E) elements[tail];
    }

    @Override
    public int getSize() {
        return (capacity - head + tail) % capacity;
    }
}
