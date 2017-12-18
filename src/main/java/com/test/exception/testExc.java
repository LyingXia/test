package com.test.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiapf on 2017/3/31 0031.
 */
public class testExc {
    public void testexc() throws Exception{
        try{
        System.out.println(11/0);
        }catch (Exception e){
            System.out.println(e);
            List<String> list = new ArrayList<String>();
        }
    }
    public static void main(String[] args){
        try{
            int a[] = new int[2];
           System.out.println("Access element three :" + a[3]);
        }catch(Exception e){
            System.out.println("Exception thrown  :" + e);
            //throw e;
        }
        System.out.println("Out of the block");
        /*int a[] = new int[2];
        System.out.println(a[3]);*/
    }
}
