package com.element.hydrogen.service.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName RandomTimeUtil
 * @Description TODO
 * @Author yanyu
 * @Date 2020/10/28 23:51
 * @Version 1.0
 */
public class RandomTimeUtil {

    public static void main(String[] args) throws ParseException {
        randomTime_YYYY_MM_DD();
    }

    /**
     * 随机生成1995-01-01~2010-12-31之间的日期
     * @return
     * @throws ParseException
     */
    private static void randomTime_YYYY_MM_DD() throws ParseException {
        String startStr = "1995.1.1";
        String endStr = "1995.12.31";
        for (int i = 0; i < 100; i++) {
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date start = sdf.parse(startStr);
            Date end = sdf.parse(endStr);
            long random = (long) (Math.random()*(end.getTime()-start.getTime()+start.getTime()));
            System.out.println(new Date(random));
        }
    }
}
