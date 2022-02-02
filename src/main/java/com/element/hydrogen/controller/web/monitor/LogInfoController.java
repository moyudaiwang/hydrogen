package com.element.hydrogen.controller.web.monitor;

import cn.hutool.http.server.HttpServerRequest;
import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.monitor.DonLogInfoEntity;
import com.element.hydrogen.service.monitor.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName LogInfoController
 * @Description 日志信息
 * @Author yanyu
 * @Date 2022/1/29 15:47
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/logInfo")
public class LogInfoController {

    @Autowired
    private LogInfoService logInfoService;

    public static ResponseJsonConstant res;

    @CrossOrigin
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ResponseJson query(@RequestBody DonLogInfoEntity donLogInfoEntity){
        return logInfoService.query(donLogInfoEntity);
    }

    @CrossOrigin
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseJson insert(HttpServerRequest request, @RequestBody DonLogInfoEntity donLogInfoEntity){
        ResponseJson resJson = new ResponseJson();
        donLogInfoEntity.setOperator("molecule");
        try{
            resJson =logInfoService.insert(donLogInfoEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseJson update(HttpServerRequest request,@RequestBody DonLogInfoEntity donLogInfoEntity){
        ResponseJson resJson = new ResponseJson();
        donLogInfoEntity.setOperator("molecule");
        try{
            resJson =logInfoService.update(donLogInfoEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseJson delete(@RequestBody List<DonLogInfoEntity> donLogInfoEntityList){
        ResponseJson resJson = new ResponseJson();
        try{
            resJson =logInfoService.delete(donLogInfoEntityList);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_DEL);
        }
        return resJson;
    }
}
