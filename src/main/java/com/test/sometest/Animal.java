package com.test.sometest;

/**
 * Created by xiapf on 2017/2/23 0023.
 */
abstract class Animal {
    public String color;
    public int numsOftui;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    //抽象方法
    abstract public void cry();
    //final 不能够被修改，不能够被覆盖(Override)   final修饰类 则表示该类不能被继承
    final public void name(){
        System.out.println("I am animal");
    }
}
//在java中 extends继承只能单继承    但是implements可以实现好多接口
class Dog extends Animal implements feed,move{
    public  void cry(){
    }

    @Override
    public void start() {}

    @Override
    public void stop() {}

    @Override
    public void move() {}

}

interface feed{
    public void start();
    public void stop();
}
interface move{
    public void move();
}
