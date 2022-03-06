package com.element.hydrogen.controller.web.graph;

import cn.hutool.http.server.HttpServerRequest;
import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.graph.DonHlmInfoEntity;
import com.element.hydrogen.service.graph.HlmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName HlmInfoController
 * @Description HlmInfoController
 * @Author yanyu
 * @Date 2022-02-26 21:35:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/hlmInfo")
public class HlmInfoController {

    @Autowired
    private HlmInfoService hlmInfoService;

    public static ResponseJsonConstant res;

    @CrossOrigin
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ResponseJson query(@RequestBody DonHlmInfoEntity donHlmInfoEntity){
        return hlmInfoService.query(donHlmInfoEntity);
    }

    @CrossOrigin
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseJson insert(HttpServerRequest request, @RequestBody DonHlmInfoEntity donHlmInfoEntity){
        ResponseJson resJson = new ResponseJson();
        donHlmInfoEntity.setOperator("molecule");
        try{
            resJson =hlmInfoService.insert(donHlmInfoEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseJson update(HttpServerRequest request,@RequestBody DonHlmInfoEntity donHlmInfoEntity){
        ResponseJson resJson = new ResponseJson();
        donHlmInfoEntity.setOperator("molecule");
        try{
            resJson =hlmInfoService.update(donHlmInfoEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseJson delete(@RequestBody List<DonHlmInfoEntity> donUserInfoEntityList){
        ResponseJson resJson = new ResponseJson();
        try{
            resJson =hlmInfoService.delete(donUserInfoEntityList);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_DEL);
        }
        return resJson;
    }
}
