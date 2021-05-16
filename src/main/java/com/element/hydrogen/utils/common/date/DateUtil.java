package com.element.hydrogen.utils.common.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description TODO
 * @Author yanyu
 * @Date 2021/5/16 17:41
 * @Version 1.0
 */
public class DateUtil {


    public String getData() {
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        System.out.println(format.format(date));
        String dateStr = format.format(date).toString();
        return dateStr;
    }
    public String getData2() {
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        System.out.println(format.format(date));
        String dateStr = format.format(date).toString();
        return dateStr;
    }

}
