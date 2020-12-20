package com.element.hydrogen.service.life.impl;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.service.life.LifeService;
import com.element.hydrogen.utils.HttpRequestUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LifeServiceImpl
 * @Description TODO
 * @Author yanyu
 * @Date 2020/11/5 23:19
 * @Version 1.0
 */
@Service
public class LifeServiceImpl implements LifeService {


    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    @Override
    public ResponseJson mobileQuery(String phone){
        ResponseJson resJson = new ResponseJson();
        String result =null;
        String url ="http://apis.juhe.cn/mobile/get";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("phone",phone);//需要查询的手机号码
        params.put("key","0305d29172dfcf68ad27b077136b9e2f");//应用APPKEY(应用详细页查询)
        try {
            result = HttpRequestUtil.request(url, params, "GET");
            resJson.setCode("200");
            resJson.setMsg("查询成功");
            resJson.setResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            resJson.setCode("500");
            resJson.setMsg("查询失败");
            resJson.setResult(result);
        }
        return resJson;
    }

}
