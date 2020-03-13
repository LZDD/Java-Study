package com.lzdd.adal.structure.stack;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/13 6:06 下午
 * 基于数组实现栈
 **/
public class MyArrayStack<E> implements IStack<E>{
    private E[] element;
    private int index = 0;

    @Override
    public void push(E e) {
        element[index++] = e;
    }

    @Override
    public E pop() {
        return element[index--];
    }

    @Override
    public E peek() {
        return element[index];
    }

    @Override
    public boolean empty() {
        return index == 0;
    }
}
