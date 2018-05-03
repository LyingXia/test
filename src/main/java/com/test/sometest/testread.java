package com.test.sometest;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;

/**
 * created by xiapf on 2018/3/6
 */
public class testread {
    public void testread() {
        try {
            File ex = new File("C:\\Users\\user\\Desktop\\test1.xlsx");
            File excelFile = ex; //创建文件对象
            FileInputStream is = new FileInputStream(excelFile); //文件流
            Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的
            Sheet sheetone  = workbook.getSheetAt(0);
            int rowCount = sheetone.getPhysicalNumberOfRows();
            System.out.println(rowCount);

            System.out.println(sheetone);
            System.out.println(sheetone.getRow(1));

//            for (int i = 1; i <= cols; i++) {
//                workbook.
//                System.out.println(workbook.getSheetAt(i));
//            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String []args)  {
        testread tr = new testread();
        tr.testread();
    }

}
