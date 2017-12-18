package com.test.arr;
import java.util.Arrays;
import com.test.sometest.*;
/**
 * Created by xiapf on 2017/3/24 0024.
 */
public class arrNew {
    public void sum() {

    }
    public void sortInsert(){
        int[] a = new int[6];
        for (int i = 1; i < a.length; i++){
            int insertVal=a[i];
            int index=i-1;
            while(index>=0&&insertVal<a[index]){
                a[index+1]=a[index];
                index--;
            }
            a[index+1]=insertVal;
        }
    }
}
