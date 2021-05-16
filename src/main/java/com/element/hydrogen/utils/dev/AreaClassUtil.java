package com.element.hydrogen.utils.dev;


import com.element.hydrogen.dto.common.AreaTest;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName AreaClassUtil
 * @Description 对省市县排序工具类：excel导入，根据右边整理省市县等级，按B/C/D分级，
 * @Author yanyu
 * @Date 2021/2/28 22:03
 * @Version 1.0
 */
public class AreaClassUtil {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\yanyu\\Desktop\\唐吉坷德文档库\\1_Oracle\\DML\\公共基础表\\AreaClassData.xlsx");
        InputStream inputStream = new FileInputStream(file);

        Workbook wb = new XSSFWorkbook(inputStream);

        Sheet sheet = wb.getSheetAt(0);
        int rownum=sheet.getLastRowNum();
        StringBuffer testStr = new StringBuffer();
        List<AreaTest> areaTestListOLD =new ArrayList<>();
        for (int i = 2; i <= rownum; i++) { //遍历每一行
            AreaTest areaTestOLD =new AreaTest();
            Row row=sheet.getRow(i);

            //testStr.append(row.getCell(2).getStringCellValue()+" ");
            //testStr.append(row.getCell(3).getStringCellValue()+" ");
            //获取单元格
            XSSFCell cell = (XSSFCell) row.getCell(9);
            //设置单元格类型
            cell.setCellType(CellType.STRING);
            //testStr.append(cell.getStringCellValue()+";\r\n");


            String areaLevel =row.getCell(2).getStringCellValue();
            String areaName =row.getCell(3).getStringCellValue();
            String areaCode =cell.getStringCellValue();

            areaTestOLD.setAreaLevel(areaLevel);
            areaTestOLD.setAreaName(areaName);
            areaTestOLD.setAreaCode(areaCode);
            areaTestListOLD.add(areaTestOLD);
        }

        List<AreaTest> areaTestListNEW = updateData(areaTestListOLD);
        for (int i = 0; i < areaTestListNEW.size(); i++) {
            testStr.append(areaTestListNEW.get(i).getAreaLevel()+"--");
            testStr.append(areaTestListNEW.get(i).getAreaName()+"--");
            testStr.append(areaTestListNEW.get(i).getAreaCode()+"\r\n");
        }

        //System.out.println("test:"+areaTestListNEW);
        System.out.println("test:"+testStr);

        //PrintWriter writer = new PrintWriter("C:\\Users\\yanyu\\Desktop\\唐吉坷德文档库\\4_Tool\\CreateTable\\result.sql") ;


    }

    private static List<AreaTest> updateData(List<AreaTest> areaTestListOLD) {
        //  List<AreaTest> areaTestListNEW =new ArrayList<>();

        for (int i = 0; i < areaTestListOLD.size(); i++) {
            String areaCode = areaTestListOLD.get(i).getAreaCode();
            String areaName = areaTestListOLD.get(i).getAreaName().trim();
            areaTestListOLD.get(i).setAreaName(areaName);
            if ("0000".equals(areaCode.substring(areaCode.length()-4,areaCode.length()))){
                areaTestListOLD.get(i).setAreaLevel("B");
                continue;
            }else if ("00".equals(areaCode.substring(areaCode.length()-2,areaCode.length()))){
                areaTestListOLD.get(i).setAreaLevel("C");
            }else if (!"00".equals(areaCode.substring(areaCode.length()-2,areaCode.length()))){
                areaTestListOLD.get(i).setAreaLevel("D");
            }
        }
        return areaTestListOLD;
    }


}
