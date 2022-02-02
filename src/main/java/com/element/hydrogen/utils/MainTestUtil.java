package com.element.hydrogen.utils;


import com.element.hydrogen.entity.book.DonBookInfoEntity;
import com.element.hydrogen.utils.common.excel.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.List;
/**
 * @ClassName MainTestUtil
 * @Description TODO
 * @Author yanyu
 * @Date 2020/12/2 23:09
 * @Version 1.0
 */
public class MainTestUtil {

    public static void main(String[] args) throws IOException, Exception {

        String fileName="bookData.xlsx";
        InputStream in = new FileInputStream(new File("D:\\Material\\bookData.xlsx"));
        Workbook wb = ExcelUtil.chooseWorkbook(fileName, in);
       // DonBookInfoEntity studentStatistics = new DonBookInfoEntity();

        //读取一个对象的信息
/*
        DonBookInfoEntity readDateT =
                ImportExeclUtil.readDateT(wb, studentStatistics, in, new Integer[] {4, 5}, new Integer[] {4, 5});
        System.out.println(readDateT);
*/

        //读取对象列表的信息
        DonBookInfoEntity studentBaseInfo = new DonBookInfoEntity();
        //第二行开始，到倒数第三行结束（总数减去两行）
        List<DonBookInfoEntity> readDateListT = ExcelUtil.readDateListT(wb, studentBaseInfo, 2, 0);
        System.out.println(readDateListT);



    }

}
