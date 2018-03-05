package com.test.sometest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiapf on 2017/2/17 0017.
 */
public class Demo{
    static int i=1;
    static {
        i++;
    }
    public Demo(){
        i++;
    }


public static void main(String []args){
    Date date = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    System.out.println(df.format(date));
}
}