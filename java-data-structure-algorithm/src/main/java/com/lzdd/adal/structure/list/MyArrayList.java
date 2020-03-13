package com.lzdd.adal.structure.list;

import java.util.Iterator;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/13 4:03 下午
 * Array数组实现列表
 **/
public class MyArrayList<E> implements IList<E> {
    private Object[] element = null;
    // 默认数组大小
    private int DEFAULT_CAPACITY = 10;
    // 实际大小
    private int capacity;
    // 数量大小
    private int size = 0;
    public MyArrayList(){
        element = new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }
    public MyArrayList(int capacity){
        if (capacity > 1){
            element = new Object[capacity];
            this.capacity = capacity;
        }else {
            element = new Object[DEFAULT_CAPACITY];
            this.capacity = DEFAULT_CAPACITY;
        }
    }

    @Override
    public E get(int i) {
        if (i < 0 || i >= size){
            return null;
        }
        return (E) this.element[i];
    }

    @Override
    public E set(int i, E t) {
        if (i < 0){
            return null;
        }
        E oldElement = (E) this.element[i];
        this.element[i] = t;
        return oldElement;
    }

    @Override
    public void add(E e) {
        // 扩容
        if (size == capacity){
            capacity = capacity >> 1;
            Object[] newElement = new Object[capacity];
            for (int j=0; j<size;j++){
                newElement[j] = element[j];
            }
            element = newElement;
        }
        this.element[size++] = e;
    }

    @Override
    public void remove(int i) {
        if (i < 0 || i >= size){
            return;
        }
        for (int j = i; j < size -1;i++){
            element[j] = element[j++];
        }
        element[--size] = null; // help GC
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> listIterator() {
        return new Itr<>();
    }

    class Itr<E> implements Iterator<E>{
        int index =0;
        @Override
        public boolean hasNext() {
            return index < size;
        }
        @Override
        public E next() {
            return (E) element[index++];
        }
    }
}
