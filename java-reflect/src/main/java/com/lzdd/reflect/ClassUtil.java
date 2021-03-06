package com.lzdd.reflect;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class ClassUtil {
    /**
     * 打印类的信息，类的成员变量
     */
    public static void printMethodMessage(Object obj){
        //要获取类的信息 首先要获取类的类类型
        //传递的是哪个子类的对象 c就是该子类的类类型
        Class c = obj.getClass();
        System.out.print("类的名称是:"+c.getName());
        /*
        * Method类，方法的对象
        * 一个成员方法就是一个Method对象
        * getMethods()方法获取所有的public的函数，包括父类继承而来的的
        * getDeclaredMethods()获取的是所有该类自己声明的方法，不问
        * */
        Method[] ms = c.getMethods();
        for (int i=0;i<ms.length;i++){
            //得到方法的返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            System.out.print(returnType.getName()+" ");
            //得到方法的名称
            System.out.print(ms[i].getName()+"(");
            //获取参数类型--->得到的是参数列表的类型的类类型
            Class[] paramTypes = ms[i].getParameterTypes();
            for (Class class1 : paramTypes){
                System.out.print(class1.getName()+",");
            }
            System.out.println(ms[i].getName()+")");
        }
    }

    /**
     * 成员变量也是对象
     * java.lang.reflect.Field
     * Field类封装了关于成员变量的操作
     * getFields()方法获取所有的public的成员变量的信息
     * getDeclaredFields()获取的是该类自己声明的成员变量的信息
     * @param obj
     */
    public static void printFieldMessage(Object obj){
        Class c = obj.getClass();
        //Field[] fs = c.getFields();
        Field[] fs = c.getDeclaredFields();
        for (Field field : fs){
            //得到成员变量的类型的类类型
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            //得到成员变量的名称
            String fieldName = field.getName();
            System.out.println(typeName+" "+fieldName);
        }
    }

    public static void printConstructorMessage(Object obj){
        Class c = obj.getClass();
        Constructor[] cs = c.getDeclaredConstructors();
        for (Constructor constructor : cs){
            System.out.print(constructor.getName()+"(");
            //获取构造函数参数列表---》得到的是参数列表的类类型
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class class1 : paramTypes){
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");
        }

    }
}
