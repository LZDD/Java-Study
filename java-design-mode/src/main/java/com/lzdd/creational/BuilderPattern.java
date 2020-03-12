package com.lzdd.creational;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/12 10:58 上午
 * 建造者模式
 * 定义：使一个复杂对象的构造和实现分离，使得可以有不同的实现。
 * 关键点：抽象构建者定义了一个产品的的所有构成部分，具体builder进行构建。
 * 理解记忆：产品House相当于一个模板，抽象构建者定义了构建的组成，具体builder根据模板构建一个对象。
 **/
public class BuilderPattern {

    public static void main(String[] args) {
        House house1 = new Director(new Builder1()).getResult();
        House house2 = new Director(new Builder2()).getResult();

        house1.show();
        house2.show();
    }
}

class House{
    private String tv;
    private String sofa;
    private String wall;

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getSofa() {
        return sofa;
    }

    public void setSofa(String sofa) {
        this.sofa = sofa;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void show(){
        System.out.println("TV:"+this.tv+"\nsofa:"+this.sofa+"\nwall:"+this.sofa);
    }
}

abstract class AbstractBuilder{
    protected House house = new House();
    public abstract void buildTv();
    public abstract void buildSofa();
    public abstract void buildWall();

    public House getResult(){
        buildTv();
        buildSofa();
        buildWall();
        return house;
    }
}

class Builder1 extends AbstractBuilder{
    @Override
    public void buildTv() {
        this.house.setTv("build1_TV");
    }

    @Override
    public void buildSofa() {
        this.house.setSofa("build1_SOFA");
    }

    @Override
    public void buildWall() {
        this.house.setWall("build1_WALL");
    }
}


class Builder2 extends AbstractBuilder{
    @Override
    public void buildTv() {
        this.house.setTv("build2_TV");
    }

    @Override
    public void buildSofa() {
        this.house.setSofa("build2_SOFA");
    }

    @Override
    public void buildWall() {
        this.house.setWall("build2_WALL");
    }
}

class Director{
    private AbstractBuilder builder;
    public Director(AbstractBuilder builder){
        this.builder = builder;
    }

    public House getResult(){
        return this.builder.getResult();
    }
}