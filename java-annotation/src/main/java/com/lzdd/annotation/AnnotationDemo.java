package com.lzdd.annotation;

import java.lang.annotation.*;

/**
 * @author Created by fei.tang@hand-china.com on 2018/1/27.
 * @description 内容交易平台
 * @Target:注解的作用目标，有类级别、方法、字段、构造函数等
 * @Retention:注解的作用范围，三个，源码、class文件、运行时
 * @Inherited:父类的注解子类是否继承
 * @Doucment:是否生成文档
 */

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AnnotationDemo {
    //自定义的属性，可以是数组，eg: String[] age() default {}
    String name() default "Default Name";
    String value() default "index";
}
