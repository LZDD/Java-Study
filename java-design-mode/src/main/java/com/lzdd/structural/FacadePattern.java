package com.lzdd.structural;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/10 12:22 下午
 * 外观模式
 * 定义：为多个复杂子系统提供一个统一的访问接口，使得子系统的改变不影响客户端的调用。
 * 关键点：定义统一的对外对象，提供访问。对象内部聚合。
 * 理解记忆：facade对象进行聚合。
 **/
public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.step();
    }
}

class SubSystem1{
    public void step(){
        System.out.println("步骤一");
    }
}

class SubSystem2{
    public void step(){
        System.out.println("步骤二");
    }
}

class SubSystem3{
    public void step(){
        System.out.println("步骤三");
    }
}

class Facade {
    private SubSystem1 subSystem1 = new SubSystem1();
    private SubSystem2 subSystem2 = new SubSystem2();
    private SubSystem3 subSystem3 = new SubSystem3();

    public void step(){
        subSystem1.step();
        subSystem2.step();
        subSystem3.step();
    }
}