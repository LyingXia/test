package com.test.sometest;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        Cat cat=new Cat();
        getDesc desc=new getDesc();
        desc.revInt(1234);

        Demo d1=new Demo();
        System.out.println(d1.i);
        Demo d2=new Demo();
        System.out.println(d2.i);
        //com.test.sometest.testSelenium t1 = new com.test.sometest.testSelenium();
        //t1.testsele("https://www.baidu.com");
        testSele t2 = new testSele();
    }
}

