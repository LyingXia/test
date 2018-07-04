package com.test.uploadFile;

/**
 * created by xiapf on 2018/6/25
 */
public class saveFile {
    //判断系统是windows还是linux，给返回
    public String winOrLin(){
        String OS = System.getProperty("os.name").toLowerCase().split(" ")[0];
        return OS;
    }

    public String saveFile(){
        return "wancheng";
    }
}
