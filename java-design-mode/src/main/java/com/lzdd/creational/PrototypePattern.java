package com.lzdd.creational;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/12 12:06 下午
 **/
public class PrototypePattern implements Cloneable {
    private String name;
    private String age;
    public PrototypePattern(String name,String age){
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypePattern p1 = new PrototypePattern("name1","age1");
        PrototypePattern p2 = (PrototypePattern) p1.clone();
        p1.show();
        p2.show();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (PrototypePattern)super.clone();
    }

    public void show(){
        System.out.println(this.hashCode() + " " + name + " " + age);
    }
}
