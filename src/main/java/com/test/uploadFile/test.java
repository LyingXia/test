package com.test.uploadFile;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * created by xiapf on 2018/6/25
 */
@RequestMapping({"/test"})
public class test {
    private String winPath  = "D:\\upload"; // win文件目录
    private String linPath = "/usr/application/uploadFile"; // lin文件目录
    saveFile sf = new saveFile();
    String os = sf.winOrLin();

    @RequestMapping(value={"uploadFile"})
    @ResponseBody
    public String saveFile(@RequestParam("parameter") String parameter, HttpServletRequest request, HttpServletResponse response){
        String savePath = linPath;
        if (os == "windows"){
            savePath = winPath;
        }
        JSONObject json = JSONObject.fromObject(parameter);
        File file = new File(savePath);

        return "";
    }

    public static void main(String[] args){
        saveFile sf = new saveFile();
        String os = sf.winOrLin();
        System.out.println(os);
    }

}
