package com.element.hydrogen.utils.factory;

import com.element.hydrogen.dto.common.AreaTest;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @ClassName IdAndPidUtil
 * @Description 行政区划中根据邮编建立id及pid关联
 * @Author yanyu
 * @Date 2021/3/1 22:15
 * @Version 1.0
 */
public class IdAndPidUtil {
    private  static  String EXC_URL ="";
    private  static  String CFG_SHEET_NAME ="Config";

    public static void main(String[] args) throws IOException {
        POIFSFileSystem cfgFS = new POIFSFileSystem(new FileInputStream(EXC_URL));
        HSSFWorkbook cfgWorkBook = new HSSFWorkbook(cfgFS);
        HSSFSheet cfgSheet = cfgWorkBook.getSheet(CFG_SHEET_NAME);

        HSSFRow row =null;
        ArrayList<AreaTest> aList= new ArrayList<AreaTest>();
        for (int i = 1; i < cfgSheet.getLastRowNum(); i++) {
            row =cfgSheet.getRow(i);
            AreaTest areaTest =new  AreaTest();
            areaTest.setId(checkType(row,0));
            areaTest.setPid(checkType(row,1));
            areaTest.setAreaLevel(checkType(row,2));
            areaTest.setAreaName(checkType(row,3));
            areaTest.setAreaCode(checkType(row,4));
            aList.add(areaTest);
        }
        
        
        //关联pid
        for(AreaTest areaTest : aList){
            if ("B".equals(areaTest.getAreaLevel())){
                areaTest.setPid("0");
            }
        }
        for(AreaTest areaTest : aList){
            if ("C".equals(areaTest.getAreaLevel())){
                String newPid = getCPid(areaTest,aList);
                areaTest.setPid(newPid);
            }
        }
        for(AreaTest areaTest : aList){
            if ("D".equals(areaTest.getAreaLevel())){
                String newPid = getDPid(areaTest,aList);
                areaTest.setPid(newPid);
            }
        }
         for(AreaTest areaTest :aList){
             System.out.println(areaTest);
        }   
        
        
        
    }

    private static String checkType(HSSFRow row, int cellNum) {
        if (HSSFCell.CELL_TYPE_NUMERIC==row.getCell(cellNum).getCellType()){
            return Double.valueOf(row.getCell(cellNum).getNumericCellValue()).toString();
        }else {
            return row.getCell(cellNum).getStringCellValue();
        }
    }


    private static String getCPid(AreaTest areaTest, ArrayList<AreaTest> aList) {
        String newPid ="";
        String aa= areaTest.getAreaCode();
        String bb = aa.substring(0,2)+"0000";
        for (AreaTest areaTest1 : aList ){
            if (areaTest1.getAreaCode().equals(bb)){
                newPid = areaTest1.getId();
            }
        }
        return newPid;
    }

    private static String getDPid(AreaTest areaTest, ArrayList<AreaTest> aList) {

        String newPid ="";
        String aa= areaTest.getAreaCode();
        String bb = aa.substring(0,4)+"00";
        for (AreaTest areaTest2 : aList ){
            if (areaTest2.getAreaCode().equals(bb)){
                newPid = areaTest2.getId();
            }
        }
        return newPid;
    }




}
