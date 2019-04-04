package com.test.worldCup;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * created by xiapf on 2018/6/27
 */
public class writeExcel {
    final String filename = "C:\\Users\\user\\Desktop\\betOdds.xlsx";
    public void xssWriteExcel(List<String[]> betOdds){
        try {
            OutputStream os = new FileOutputStream(filename);
            SXSSFWorkbook xsswb = new SXSSFWorkbook();
            SXSSFSheet xsssht = null;
            int sheetNum = xsswb.getNumberOfSheets();
            for (int a=0; a < sheetNum;a++){
                if (xsswb.getSheetName(a) == "odds"){
                    xsssht = xsswb.getSheet("odds");
                }
            }
            if (xsssht == null){
                xsssht = xsswb.createSheet("odds");
            }
            List<String[]> hasRead = xssReadExcel(filename);
            for(int i=0 ; i<betOdds.size();i++ ){
                for ( int z=0 ; z<hasRead.size();z++){
                    if(betOdds.get(i)[0] == hasRead.get(z)[0] &&betOdds.get(i)[1] == hasRead.get(z)[1] ) {
                        Row right_now_row = xsssht.getRow(z);
                        int right_now_length = right_now_row.getPhysicalNumberOfCells();
                        Cell need_write = right_now_row.createCell(right_now_length + 1);
                        need_write.setCellValue(betOdds.get(i)[-1]);
                    }
                }
               Row rows = xsssht.createRow(i);
                for(int j=0; j<betOdds.get(i).length;j++){
                    Cell cells = rows.createCell(j);
                    cells.setCellValue(betOdds.get(i)[j]);
                }
            }
            xsswb.write(os);
            xsswb.close();
            os.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void xssWriteExcel2(List<String[]> betOdds){
        try {
            //因为不能读写同时操作，所以先读一遍，然后再写
            List<String[]> hasRead = xssReadExcel(filename);
            //创建流
            OutputStream os = new FileOutputStream(filename);
            //创建工作簿
            SXSSFWorkbook xsswb = new SXSSFWorkbook();
            SXSSFSheet xsssht = null;
            int oddsint;
            //查找文件中的odds名称的sheet的位置，如果找不到是-1,
            if(hasRead.size() > 1) {
                oddsint = Integer.parseInt(hasRead.get(hasRead.size()-1)[0]);
            }else{
                oddsint = -1 ;
            }
            // 如果找到了名称为odds的sheet
            if(oddsint >= 0 && hasRead.size() > 0){
                xsssht = xsswb.getSheetAt(oddsint);
                //获取该sheet共有多少行
                int rowNum = Integer.parseInt(hasRead.get(hasRead.size()-1)[1]);
                for(int i=0; i<rowNum; i++){
                    //获取该行共有多少cell
                    /**int colNum = xsssht.getRow(i).getPhysicalNumberOfCells();*/
                    int colNum = hasRead.get(i).length;
                    /**String[] cellvalues = new String[colNum];*/
                    for(int j=0; j<betOdds.size(); j++){
                        //将excel中的值加入Array中
                        if(hasRead.get(i)[0].equals(betOdds.get(j)[0])  && hasRead.get(i)[1].equals(betOdds.get(j)[1]) ){
                            //将Array中的最后一位加入到Cell中
                            int n = betOdds.get(j).length - 1;
                            xsssht.getRow(i).createCell(hasRead.get(i).length).setCellValue(betOdds.get(j)[n]);
                        }
                    }
                    //将Array 加入到 List中
                    /**hasRead.add(cellvalues);*/
                }

            }else{
                xsssht = xsswb.createSheet("odds");
                for (int i=0; i<betOdds.size(); i++){
                    xsssht.createRow(i);
                    for (int j=0; j<betOdds.get(i).length; j++){
                        xsssht.getRow(i).createCell(j).setCellValue(betOdds.get(i)[j]);
                    }
                }
            }
            xsswb.write(os);
            xsswb.close();
            os.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<String[]> xssReadExcel(String  filename){
        List<String[]> value = new ArrayList();
        String[] oddsvalue = new String[2];
        try {
            //创建流，Input的是 读时候用的
            FileInputStream is = new FileInputStream(filename);
            //创建poi的Workbook
            org.apache.poi.ss.usermodel.Workbook xsswb = WorkbookFactory.create(is);
            //查找名字为odds的Sheet
            int oddsint = xsswb.getSheetIndex("odds");
            org.apache.poi.ss.usermodel.Sheet sheet = xsswb.getSheet("odds");
            //获取当前sheet中一共有多少行
            int rowNum = sheet.getPhysicalNumberOfRows();
            oddsvalue[0] = String.valueOf(oddsint);
            oddsvalue[1] = String.valueOf(rowNum);
            int cellNum;
            for(int i=0; i<rowNum;i++){
                // 获取当前行中一共有多少列
                cellNum = sheet.getRow(i).getPhysicalNumberOfCells();
                //定义一个长度和列数相同数组
                String[] cellValue = new String[cellNum];
                for(int j=0;j<cellNum;j++){
                    //获取第I行中第J列的值，并转化成String形式
                    cellValue[j] = sheet.getRow(i).getCell(j).toString();
                }
                //将数组添加到List中
                value.add(cellValue);
            }
            is.close();
            xsswb.close();
        }catch (Exception e){
            System.out.println(e);
        }
        value.add(oddsvalue);
        return value;
    }

    public static void main(String[] args){
        String filename = "C:\\Users\\user\\Desktop\\betOdds.xlsx";
        writeExcel we = new writeExcel();
//        we.poiWriteExcel();
        System.out.println(we.xssReadExcel(filename));

    }
}
