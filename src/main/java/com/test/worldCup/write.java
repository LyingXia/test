package com.test.worldCup;

import java.io.*;
import java.util.ArrayList;

/**
 * created by xiapf on 2018/6/27
 */
public class write {
    String filename = "C:\\Users\\user\\Desktop\\betOdds.txt";
    File file = new File(filename);
    public void writeTxt(String s){
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            fw = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //向txt中写入内容
        PrintWriter pw = new PrintWriter(fw);
        ArrayList rf = readFileByLines();
        if (rf != null) {
            for (int i = 0; i < rf.size(); i++) {
                System.out.println(i);
                System.out.println(rf.get(i));
                if (s.substring(0,5) == rf.get(i).toString().substring(0,5)){
                    /**这里需要写东西 目前还没有写*/

                }
            }
        }
        pw.println(s);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  ArrayList readFileByLines() {
        BufferedReader reader = null;
        ArrayList content = new ArrayList();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                //System.out.println("line " + line + ": " + tempString);
                content.add(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return content;
    }
}
