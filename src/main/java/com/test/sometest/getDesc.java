package com.test.sometest;

/**
 * Created by xiapf on 2017/2/15 0015.
 */
public class getDesc {
    public  int revInt(int a){
        String b = Integer.toString(a);
        int l=b.length();
        String c="";
        for (int i=l-1;i>=0;i--){
            c=c+b.charAt(i);
        }
        int s=Integer.parseInt(c);
        System.out.println(s);
        return s;

    }
}
