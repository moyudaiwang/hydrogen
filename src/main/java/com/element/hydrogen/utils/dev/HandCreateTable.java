package com.element.hydrogen.utils.dev;

import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @ClassName HandCreateTable
 * @Description 建表工具：导入Excel生成mysql建表文件
 * 1、生成备份原有表数据的SQL：DROP TABLE DON_USER_INFO_BAK;
 * CREATE TABLE DON_USER_INFO_BAK AS SELECT * FROM DON_USER_INFO;
 * 2:生成delete表结构语句；
 * 3：生成新的建表语句；
 * @Author yanyu
 * @Date 2021/4/22 21:30
 * @Version 1.0
 */
public class HandCreateTable {

    private  static final  String EXCEL_PATH ="C:\\Users\\yanyu\\Desktop\\唐吉坷德文档库\\4_Tool\\CreateTable\\TableFile.xls";  //要读取的Excel路径
    private  static final  String SQL_PATH ="C:\\Users\\yanyu\\Desktop\\唐吉坷德文档库\\4_Tool\\CreateTable\\result.sql";  //要生成的建表SQL的路径

    private  static final  int LOOP_NUM =10;  //循环几个工作表（sheet）

    public static void main(String[] args) throws Exception {
        File file = new File(EXCEL_PATH);
        Workbook wb = Workbook.getWorkbook(file);

        Sheet[] sheets = wb.getSheets();
        System.out.println("当前文件夹的sheet数量" + sheets.length);
        Date dateStart = new Date();
        PrintWriter writer = new PrintWriter(SQL_PATH) ;
        //循环生成备份表SQL
        writer.write("-- bak Table DDL:\r\n");
        for (int i = 0; i < LOOP_NUM; i++) {
            Sheet sheet = wb.getSheet(i);
            String bakStr = bakTale(sheet);
            writer.write(bakStr);
        }
        //循环生成删除
        writer.write("-- delete Table DDL:\r\n");
        for (int i = 0; i < LOOP_NUM; i++) {
            Sheet sheet = wb.getSheet(i);
            String deleteStr = deleteTale(sheet);
            writer.write(deleteStr);
        }
        writer.write("\r\n");
        //循环生成建表
        for (int i = 0; i < LOOP_NUM; i++) {
            Sheet sheet = wb.getSheet(i);
            String createStr = createstatement(sheet);
            writer.write(createStr);
        }
        writer.close();
        Date dateEnd = new Date();
        System.out.println("生成完毕，一共用时："+(dateEnd.getTime()-dateStart.getTime())/1000+"秒");
    }

    //生成备份原有表数据ddl
    private static String bakTale(Sheet sheet) {
        StringBuffer bakStr = new StringBuffer();
        bakStr.append("DROP TABLE "+sheet.getCell(0, 0).getContents()+ "_BAK;\r\n");
        bakStr.append("CREATE TABLE "+sheet.getCell(0, 0).getContents()+ "_BAK AS SELECT * FROM "+sheet.getCell(0, 0).getContents() + ";\r\n");
        return bakStr.toString();
    }

    //生成删除表ddl
    private static String deleteTale(Sheet sheet) {
        StringBuffer delStr = new StringBuffer();
        //delStr.append("-- SELECT * FROM "+sheet.getCell(0, 0).getContents()+ ";\r\n");
        //delStr.append("DELETE TABLE "+sheet.getCell(0, 0).getContents()+ ";\r\n");
        return delStr.toString();
    }

    // 生成建表语句的方法
    public static String createstatement(Sheet sheet) {
        StringBuffer bodysb = new StringBuffer(); // 建表语句的表头和结尾注释不分
        StringBuffer fldsb = new StringBuffer(); // 字段部分
        StringBuffer commentsb = new StringBuffer(); // 表中文名
        StringBuffer partitionsb = new StringBuffer(); // 分区字段部分
        bodysb.append("-- "+sheet.getCell(0, 0).getContents()+" DDL：\r\n");
        //bodysb.append("-- SELECT * FROM "+sheet.getCell(0, 0).getContents()+ ";\r\n");
        bodysb.append("DELETE TABLE "+sheet.getCell(0, 0).getContents()+ ";\r\n");
        bodysb.append("CREATE TABLE "+sheet.getCell(0, 0).getContents());
        // 表头部分
        bodysb.append(" (\r\n");
        // 表中文名
        commentsb.append("ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT ='" + sheet.getCell(1, 0).getContents() + "';\r\n\n");
        // 字段部分

        for (int i = 2; i < sheet.getRows(); i++) {
            // 首行处理
            if (i == 2) {
                fldsb.append(" " + sheet.getCell(0, 2).getContents() + " " + sheet.getCell(1, 2).getContents());
                String isNullVal = sheet.getCell(2, 2).getContents();
                String defaultVal = sheet.getCell(3, 2).getContents();
                if ("N".equals(isNullVal.toUpperCase())) { //不允许为null
                    fldsb.append(" NOT NULL");
                    if (!"".equals(defaultVal)) { //存在默认
                        fldsb.append(" DEFAULT '" + defaultVal + "'");
                    }
                } else {
                    fldsb.append(" DEFAULT NULL");
                }
                if (!"".equals(sheet.getCell(4, 2).getContents())) {
                    fldsb.append(" COMMENT '" + sheet.getCell(4, 2).getContents() + "',\r\n");
                }else{
                    fldsb.append(",\r\n");
                }

            } else if (i > 2 && i < sheet.getRows() - 1) {
                for (int j = 0; j <= 4; j++) {
                    switch (j) {
                        case 0:
                            fldsb.append(" " + sheet.getCell(j, i).getContents());
                            break;
                        case 1:
                            fldsb.append(" " + sheet.getCell(j, i).getContents());
                            break;
                        case 2:
                            String isNullVal = sheet.getCell(j, i).getContents();
                            int addj = j + 1;//将默认值一并处理
                            String defaultVal = sheet.getCell(addj, i).getContents();
                            if ("N".equals(isNullVal.toUpperCase())) { //不允许为null
                                fldsb.append(" NOT NULL");
                                if (!"".equals(defaultVal)) { //存在默认
                                    fldsb.append(" DEFAULT '" + defaultVal + "'");
                                }
                            } else {
                                fldsb.append(" DEFAULT NULL");
                            }
                            break;
                        case 3:
                            break;
                        case 4:
                            if (!"".equals(sheet.getCell(j, i).getContents())) {
                                fldsb.append(" COMMENT '" + sheet.getCell(j, i).getContents() + "',\r\n");
                            }else{
                                fldsb.append(",\r\n");
                            }
                            break;
                        default:
                            break;
                    }
                }
            } else {
                fldsb.append(" " + sheet.getCell(0, sheet.getRows() - 1).getContents() + " " + sheet.getCell(1, sheet.getRows() - 1).getContents());
                String isNullVal = sheet.getCell(2, sheet.getRows() - 1).getContents();
                String defaultVal = sheet.getCell(3, sheet.getRows() - 1).getContents();
                if ("N".equals(isNullVal.toUpperCase())) { //不允许为null
                    fldsb.append(" NOT NULL");
                    if (!"".equals(defaultVal)) { //存在默认
                        fldsb.append(" DEFAULT '" + defaultVal + "'");
                    }
                } else {
                    fldsb.append(" DEFAULT NULL");

                }
                fldsb.append(" COMMENT '" + sheet.getCell(4, sheet.getRows() - 1).getContents() + "',\r\n");
                fldsb.append(" PRIMARY KEY (" + sheet.getCell(0, sheet.getRows() - 1).getContents() + ")\r\n)");
            }

        }

        // 合并结果集
        StringBuffer result = new StringBuffer();
        result = bodysb.append(fldsb).append(commentsb).append(partitionsb);
        return result.toString();
    }
}
