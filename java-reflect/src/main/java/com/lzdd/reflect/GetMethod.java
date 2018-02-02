package com.lzdd.reflect;
public class GetMethod {
    public static void main(String[] aegs){
        Class c1 = int.class;//int的类类型
        Class c2 = String.class;//String类的类类型 String类的字节码
        Class c3 = double.class;
        Class c4 = Double.class;//c3和c4不一样

        ClassUtil.printMethodMessage("Stirng");
        System.out.println("============");
        ClassUtil.printFieldMessage("String");
        System.out.println("============");
        ClassUtil.printConstructorMessage("String");
    }
}
