package com.lzdd.behavioral;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/5 11:11 上午
 * 备忘录模式，又称快照模式
 * 定义：在不破坏数据结构的前提下，将对象的内部状态保存到状态对象中，以便以后可以恢复原有状态
 * 关键点：发起人的理解。
 * 理解记忆：主要是发起人，发起人生成一个备忘录，将备忘录交给管理者，然后可以从管理者获取备忘录，将发起人的状态恢复到备忘录的状态
 **/
public class MementoPattern {

    public static void main(String[] args) {
        CareTaker ct = new CareTaker();
        Originator o = new Originator();
        o.setState("s1");
        ct.setMemento(o.createMemento());
        System.out.println(o.getState());
        o.setState("s2");
        System.out.println(o.getState());
        o.restoreMemento(ct.getMemento());
        System.out.println(o.getState());

    }

}

/**
 * 备忘录类
 */
class Memento{
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}


/**
 * 发起人类
 */
class Originator{
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento(){
        return new Memento(state);
    }

    public void restoreMemento(Memento memento){
        this.state = memento.getState();
    }
}

/**
 * 管理者
 */
class CareTaker{
    private Memento memento;


    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}