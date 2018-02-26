package com.test.applications.qmclotserver.overwrite11x5;

import java.util.ArrayList;

/**
 * created by xiapf on 2018/1/9
 */
public class arrtoNN {
    ArrayList b = new ArrayList();
    //arr为原始数组
    //NUM为要选取的元素个数
    //count为result数组的索引值，起辅助作用
    //result保存结果，为一维数组
    //start为遍历起始位置
    //arr_len为原始数组的长度，为定值
    public void combine_increase(String[] arr, int start, int[] result, int count, int NUM, int arr_len) {
        ArrayList a = new ArrayList();
        for (int i = start; i < arr_len + 1 - count; i++) {
            result[count - 1] = i;
            if (count - 1 == 0) {
                for (int j = NUM - 1; j >= 0; j--) {
                    a.add(arr[result[j]]);
                    //System.out.println(a);
                }
                System.out.println(a);
            } else {
                combine_increase(arr, i + 1, result, count - 1, NUM, arr_len);
            }
            a.clear();
        }
        System.out.println(b);
        //if(b.size() = )
    }
/*    //arr为原始数组
    //start为遍历起始位置
    //result保存结果，为一维数组
    //count为result数组的索引值，起辅助作用
    //NUM为要选取的元素个数
    public void combine_decrease(String[] arr, int start, int[] result, int count, int NUM) {
        ArrayList a = new ArrayList();
        for (int i = start; i >=count; i--) {
            result[count - 1] = i - 1;
            if (count > 1) {
                combine_decrease(arr, i - 1, result, count - 1, NUM);
            } else {
                for (int j = NUM - 1; j >=0; j--) {
                    a.add(arr[result[j]]);
                    System.out.println(a);
                }
                System.out.println(a);
            }
            a.clear();
        }
    }*/

    public static void main(String[] args) {
        String[] arr = {"1","2","3","4","5","6"};
        int num = 4;
        int[] result = new int[num];
        arrtoNN ar = new arrtoNN();
        ar.combine_increase(arr, 0, result, num, num, arr.length);
        /*System.out.println("分界线\n");
        ar.combine_decrease(arr, arr.length, result, num, num);*/
    }
}
