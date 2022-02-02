package com.element.hydrogen.controller.web.auth;

import cn.hutool.http.server.HttpServerRequest;
import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.auth.DonAccountInfoEntity;
import com.element.hydrogen.service.auth.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName AccountInfoController
 * @Description 账号信息
 * @Author yanyu
 * @Date 2022-02-03 02:27:00
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/accountInfo")
public class AccountInfoController {

    @Autowired
    private AccountInfoService accountInfoService;

    public static ResponseJsonConstant res;

    @CrossOrigin
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ResponseJson query(@RequestBody DonAccountInfoEntity donAccountInfoEntity){
        return accountInfoService.query(donAccountInfoEntity);
    }

    @CrossOrigin
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseJson insert(HttpServerRequest request, @RequestBody DonAccountInfoEntity donAccountInfoEntity){
        ResponseJson resJson = new ResponseJson();
        donAccountInfoEntity.setOperator("molecule");
        try{
            resJson =accountInfoService.insert(donAccountInfoEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseJson update(HttpServerRequest request,@RequestBody DonAccountInfoEntity donAccountInfoEntity){
        ResponseJson resJson = new ResponseJson();
        donAccountInfoEntity.setOperator("molecule");
        try{
            resJson =accountInfoService.update(donAccountInfoEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseJson delete(@RequestBody List<DonAccountInfoEntity> donUserInfoEntityList){
        ResponseJson resJson = new ResponseJson();
        try{
            resJson =accountInfoService.delete(donUserInfoEntityList);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_DEL);
        }
        return resJson;
    }
}
