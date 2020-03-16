package com.lzdd.adal.structure.queue;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/13 6:18 下午
 **/
public interface IQueue<E> {
    boolean add(E e);
    //boolean offer(E e);
    E remove();
    //E poll();
    E element();
    //E peek();
    int getSize();
}
