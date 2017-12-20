package com.test.applications.qmclotserver;

import org.apache.poi.ss.usermodel.*;
import org.json.JSONException;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;

// xmlbeans,Commons Collections,poi-ooxml-schemas除了以上引入的包、还需要加入这些jar包

/**
 * Created by xiapf on 2017/10/19 0019.
 */
public class readExcel {
    public static String[][] readExcelReturnarrArr(File file){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        String res = ""; // 先声明一下要返回的值
        try {
            //同时支持Excel 2003、2007
            File excelFile = file; //创建文件对象
            FileInputStream is = new FileInputStream(excelFile); //文件流
            Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的
            int sheetCount = workbook.getNumberOfSheets();  //Sheet的数量
            //遍历每个Sheet
            for (int s = 0; s < sheetCount; s++) {
                Sheet sheet = workbook.getSheetAt(s);
                int rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数
                //遍历每一行
                for (int r = 0; r < rowCount; r++) {
                    Row row = sheet.getRow(r);
                    int cellCount = row.getPhysicalNumberOfCells(); //获取总列数
                    //遍历每一列
                    for (int c = 0; c < cellCount; c++) {
                        Cell cell = row.getCell(c);
                        int cellType = cell.getCellType();
                        String cellValue = null;
                        switch(cellType) {
                            case Cell.CELL_TYPE_STRING: //文本
                                cellValue = cell.getStringCellValue();
                                break;
                            case Cell.CELL_TYPE_NUMERIC: //数字、日期
                                if(DateUtil.isCellDateFormatted(cell)) {
                                    cellValue = fmt.format(cell.getDateCellValue()); //日期型
                                }
                                else {
                                    cellValue = String.valueOf(cell.getNumericCellValue()); //数字
                                }
                                break;
                            case Cell.CELL_TYPE_BOOLEAN: //布尔型
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case Cell.CELL_TYPE_BLANK: //空白
                                cellValue = cell.getStringCellValue();
                                break;
                            case Cell.CELL_TYPE_ERROR: //错误
                                cellValue = "错误";
                                break;
                            case Cell.CELL_TYPE_FORMULA: //公式
                                cellValue = "错误";
                                break;
                            default:
                                cellValue = "错误";
                        }
                        if(c == cellCount-1) { // 每行的最后一个后面加的是HFGF ，区别好多行
                            res = res + cellValue + "HFGF";
                        }else{  // 行之间的参数为了方便拆分 所以加了FGF标识
                            res = res + cellValue + "FGF";
                        }
                    }
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String[] a = res.split("HFGF");
        String[][] b = new String[a.length][];
        for (int i=0; i< a.length;i++){
            b[i]=a[i].split("FGF");
        }
        return  b;
    }


    public static void main(String[] args) throws JSONException {
//       File file = new File("C:\\Users\\user\\Desktop\\Desktop\\phone.xlsx");
        File file = new File("C:\\Users\\user\\Desktop\\test.xlsx");
       /* 字符串传递模式
        otherPost op  = new otherPost();
        op.otherRqt(file);*/
       //json传递模式
        otherPost1 op1 = new otherPost1();
        op1.otherRqt(file);
        op1.otherSedRqt(file);

    }
}
