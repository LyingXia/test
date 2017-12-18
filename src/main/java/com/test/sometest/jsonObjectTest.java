package com.test.sometest;

import net.sf.json.JSONObject;

/**
 * created by xiapf on 2017/12/15
 */
public class jsonObjectTest {
    public static void main(String[] args){
        JSONObject json = new JSONObject();
        JSONObject json1 = new JSONObject();

        json.put("userName","xpf");
        json.put("userName","xpf1");
        json1.put("password","123456");
        json.putAll(json1);
        System.out.println(json);

    }
}
