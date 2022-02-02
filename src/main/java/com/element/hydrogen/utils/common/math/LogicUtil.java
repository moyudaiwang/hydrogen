package com.element.hydrogen.utils.common.math;

/**
 * @ClassName LogicUtil
 * @Description TODO 逻辑工具类
 * @Author yanyu
 * @Date 2021/1/31 1:32
 * @Version 1.0
 */
public class LogicUtil {

    public static boolean noEmpty(String param) {
        Boolean flag =false;
        if (param.isEmpty() || param == null){
           flag =false;
        } else {
           flag =true;
        }
        return flag;
    }

}
