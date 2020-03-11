package com.lzdd.structural;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/11 11:24 上午
 * 代理模式
 * 定义：由于某些原因，客户端不能直接引用目标对象，需要通过代理作为中介，起到控制和保护作用。
 * 关键点：目标对象和代理类实现同一个接口。
 * 理解记忆：在代理对象中调用目标对象，并添加一些额外操作。
 **/
public class ProxyPattern {

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.operate();

        DynamicMediator mediator = new DynamicMediator(new Delegation());
        ISubject p = (ISubject)(java.lang.reflect.Proxy.newProxyInstance(ISubject.class.getClassLoader(),new Class[]{ISubject.class},mediator));
        p.operate();
    }
}

interface ISubject{
    void operate();
}

class Subject1 implements ISubject{

    @Override
    public void operate() {
        System.out.println("Subject1 目标对象");
    }
}

class Proxy implements ISubject{
    private Subject1 subject1 = new Subject1();
    @Override
    public void operate() {
        System.out.println("proxy 前置处理");
        subject1.operate();
        System.out.println("proxy 后置处理");
    }
}

/**
 * 以下是java动态代理，通过媒介类，动态生成代理类
 * 生成的Proxy代理类 -> 媒介类的invoke方法 -> 委托对象的方法
 */

// step1 委托类，要实现Subject接口
class Delegation implements ISubject{
    @Override
    public void operate() {
        System.out.println("委托类中的操作");
    }
}

// step2 媒介类，要实现InvocationHandle接口
class DynamicMediator implements InvocationHandler {
    private Object object;
    public DynamicMediator(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理前置步骤---");
        Object result = method.invoke(object,args);
        System.out.println("动态代理后置步骤---");
        return result;
    }
}

// step3 通过Proxy类动态生成代理类



