package com.lzdd.behavioral;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/5 11:57 上午
 * 访问者模式
 * 定义：在不破坏数据结构的前提下，将数据元素的操作抽象出来，组成对象。可以添加不同的访问方式。元素和操作分离。
 * 关键点：元素对象的 accept(Visitor) 方法
 * 理解记忆：元素将访问这作为入参传入，调用访问者的方法访问自己。
 **/
public class VisitorPattern {
    public static void main(String[] args) {
        // 数据结构
        ObjectStructure os = new ObjectStructure();

        //构建元素并添加到数据结构中
        os.addElement(new Element1());
        os.addElement(new Element1());

        //访问方式
        os.accept(new Visitor1());
        os.accept(new Visitor2());
    }
}

/**
 * 访问者
 */
interface IVisitor{
    void visit(Element1 element1);
    void visit(Element2 element2);
}

class Visitor1 implements IVisitor{
    private String prefix = "访问者1:";
    @Override
    public void visit(Element1 element1) {
        System.out.println(prefix + element1.getName());
    }

    @Override
    public void visit(Element2 element2) {
        System.out.println(prefix + element2.getName());
    }
}

class Visitor2 implements IVisitor{
    private String prefix = "访问者2:";

    @Override
    public void visit(Element1 element1) {
        System.out.println(prefix + element1.getName());
    }

    @Override
    public void visit(Element2 element2) {
        System.out.println(prefix + element2.getName());
    }
}

/**
 * 元素
 */
interface IElement{
    void accept(IVisitor visitor);
}

class Element1 implements IElement{
    private String name = "element1";
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Element2 implements IElement{
    private String name = "element2";

    @Override
    public void accept(IVisitor visitor) {
        // 自己触发访问自己
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ObjectStructure{
    private List<IElement> elements = Lists.newLinkedList();


    public void addElement(IElement element){
        this.elements.add(element);
    }

    public void accept(IVisitor visitor){
        Iterator<IElement> it = elements.iterator();
        while (it.hasNext()){
            it.next().accept(visitor);
        }
    }

}