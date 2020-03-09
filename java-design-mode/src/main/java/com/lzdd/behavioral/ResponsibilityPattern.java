package com.lzdd.behavioral;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/9 12:15 下午
 * 责任链模式
 * 定义：为避免一个请求发送者与多个请求处理这发生耦合，将所有请求对象处理者通过前一个对象记录下一个
 *      处理对象的引用，构成一条链。
 * 关键点：请求处理者，IHandle的定义，自己拥有自己的引用。
 * 理解记忆：IHandle的前后引用关系由客户端决定。
 **/
public class ResponsibilityPattern {

    public static void main(String[] args) {
        IHandle handle1 = new Handle1();
        IHandle handle2 = new Handle2();
        handle1.setNext(handle2);
        handle1.handleRequest("one");
        handle1.handleRequest("two");
    }
}

abstract class IHandle{
    private IHandle next;

    public IHandle getNext() {
        return next;
    }

    public void setNext(IHandle next) {
        this.next = next;
    }

    abstract void handleRequest(String condition);
}

class Handle1 extends IHandle {

    @Override
    void handleRequest(String condition) {
        if ("one".equals(condition)){
            System.out.println("handle1 处理结果");
        }else if (getNext() != null){
            getNext().handleRequest(condition);
        }else {
            System.out.println("没有处理方法");
        }
    }
}

class Handle2 extends IHandle {

    @Override
    void handleRequest(String condition) {
        if ("two".equals(condition)){
            System.out.println("handle2 处理结果");
        }else if (getNext() != null){
            getNext().handleRequest(condition);
        }else {
            System.out.println("没有处理方法");
        }
    }
}