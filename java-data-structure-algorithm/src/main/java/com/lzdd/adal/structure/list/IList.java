package com.lzdd.adal.structure.list;

import java.util.Iterator;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/13 3:57 下午
 **/
public interface IList<E> {
    E get(int i);
    E set(int i, E t);
    void remove(int i);
    int size();
    Iterator<E> listIterator();
}
