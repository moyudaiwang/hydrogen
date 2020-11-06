package com.element.hydrogen.controller.web.life;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.service.life.LifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName LifeController
 * @Description TODO
 * @Author yanyu
 * @Date 2020/11/5 23:18
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/life")
public class LifeController {
    @Autowired
    private LifeService lifeService;

    /**
     * 聚合信息:查询手机号归属地
     * @param phone
     * @return
     */
    @RequestMapping(value = "/mobileQuery",method = RequestMethod.POST)
    public ResponseJson mobileQuery(@RequestParam String phone){
        ResponseJson resJson = new ResponseJson();
        try{
            resJson =lifeService.mobileQuery(phone);
            System.out.println(resJson);
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMessage("查询失败");
        }
        return resJson;
    }

}
