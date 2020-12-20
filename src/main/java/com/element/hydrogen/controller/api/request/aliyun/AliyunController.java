package com.element.hydrogen.controller.api.request.aliyun;

import com.element.hydrogen.utils.HttpRequestUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AliyunController
 * @Description TODO
 * @Author yanyu
 * @Date 2020/12/6 21:48
 * @Version 1.0
 */
public class AliyunController {


    public static void main(String[] args) {
        String result =null;
        String url ="http://apis.juhe.cn/mobile/get";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("phone","13429667914");//需要查询的手机号码
        params.put("key","0305d29172dfcf68ad27b077136b9e2f");//应用APPKEY(应用详细页查询)
        try {
            result = HttpRequestUtil.request(url, params, "GET");
            System.out.println("result:"+result);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
