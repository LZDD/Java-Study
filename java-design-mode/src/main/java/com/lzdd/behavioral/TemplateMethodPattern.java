package com.lzdd.behavioral;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/9 3:32 下午
 * 模板方法模式
 * 定义：定义一个操作的算法骨架，将某些步骤的实现可以延迟到子类中，使得子类可以不改变算法的大体结构，可以改变父类的逻辑。
 * 关键点：AbstractTemplate是一个抽象类。定义了所有步骤。
 * 理解记忆：AbstractTemplate是一个抽象类。定义了所有步骤。
 **/
public class TemplateMethodPattern {
    public static void main(String[] args) {
        Template1 template1 = new Template1();
        template1.templateMethod();
        Template2 template2 = new Template2();
        template2.templateMethod();
    }
}

abstract class AbstractTemplate{

    public void templateMethod(){
        specificMethod1();
        specificMethod2();
        hookMethod1();
        abstractMethod1();
        abstractMethod2();
    }

    protected void specificMethod1(){
        System.out.println("specificMethod1 执行");
    }

    protected void specificMethod2(){
        System.out.println("specificMethod2 执行");
    }

    protected boolean hookMethod1(){
        System.out.println("hookMethod1 返回true");
        return true;
    }

    protected void hookMethod2(){
        if (hookMethod1()){
            System.out.println("hookMethod2 执行");
        }
    }

    protected abstract void abstractMethod1();
    protected abstract void abstractMethod2();
}

class Template1 extends AbstractTemplate{

    @Override
    protected void abstractMethod1() {
        System.out.println("Template1 abstractMethod1 执行 ");
    }

    @Override
    protected void abstractMethod2() {
        System.out.println("Template1 abstractMethod2 执行 ");
    }
}


class Template2 extends AbstractTemplate{

    @Override
    protected boolean hookMethod1() {
        System.out.println("Template2 hookMethod1 返回false");
        return false;
    }

    @Override
    protected void abstractMethod1() {
        System.out.println("Template2 abstractMethod1 执行 ");
    }

    @Override
    protected void abstractMethod2() {
        System.out.println("Template2 abstractMethod2 执行 ");
    }
}