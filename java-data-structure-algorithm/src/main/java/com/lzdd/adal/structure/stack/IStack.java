package com.lzdd.adal.structure.stack;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/13 6:04 下午
 **/
public interface IStack<E> {
    void push(E e);
    E pop();
    E peek();
    boolean empty();
}
