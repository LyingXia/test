package com.test.sometest;

/**
 * Created by xiapf on 2017/2/13 0013.
 */
public class Cat{
    private String name;
    private String age;
    private String color;
    private int score[]={};

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
        System.out.println(age);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getAge() {
        return age;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

}
