package com.element.hydrogen.controller.web.auth;

import cn.hutool.http.server.HttpServerRequest;
import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.auth.DonMenuInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.service.auth.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName MenuInfoController
 * @Description 菜单信息
 * @Author yanyu
 * @Date 2022-02-03 01:24:41
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/menuInfo")
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;

    public static ResponseJsonConstant res;

    @CrossOrigin
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ResponseJson query(@RequestBody DonMenuInfoEntity donMenuInfoEntity){
        return menuInfoService.query(donMenuInfoEntity);
    }

    @CrossOrigin
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseJson insert(HttpServerRequest request, @RequestBody DonMenuInfoEntity donMenuInfoEntity){
        ResponseJson resJson = new ResponseJson();
        donMenuInfoEntity.setOperator("molecule");
        try{
            resJson =menuInfoService.insert(donMenuInfoEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseJson update(HttpServerRequest request,@RequestBody DonMenuInfoEntity donMenuInfoEntity){
        ResponseJson resJson = new ResponseJson();
        donMenuInfoEntity.setOperator("molecule");
        try{
            resJson =menuInfoService.update(donMenuInfoEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseJson delete(@RequestBody List<DonMenuInfoEntity> donUserInfoEntityList){
        ResponseJson resJson = new ResponseJson();
        try{
            resJson =menuInfoService.delete(donUserInfoEntityList);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_DEL);
        }
        return resJson;
    }
}
