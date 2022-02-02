package com.element.hydrogen.controller.web.user;

import cn.hutool.http.server.HttpServerRequest;
import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.user.DonUserInfoEntity;
import com.element.hydrogen.service.user.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UserInfoController
 * @Description 用户信息
 * @Author yanyu
 * @Date 2022-02-03 03:31:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    public static ResponseJsonConstant res;

    @CrossOrigin
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ResponseJson query(@RequestBody DonUserInfoEntity donUserInfoEntity){
        return userInfoService.query(donUserInfoEntity);
    }

    @CrossOrigin
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseJson insert(HttpServerRequest request, @RequestBody DonUserInfoEntity donUserInfoEntity){
        ResponseJson resJson = new ResponseJson();
        donUserInfoEntity.setOperator("molecule");
        try{
            resJson =userInfoService.insert(donUserInfoEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseJson update(HttpServerRequest request,@RequestBody DonUserInfoEntity donUserInfoEntity){
        ResponseJson resJson = new ResponseJson();
        donUserInfoEntity.setOperator("molecule");
        try{
            resJson =userInfoService.update(donUserInfoEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseJson delete(@RequestBody List<DonUserInfoEntity> donUserInfoEntityList){
        ResponseJson resJson = new ResponseJson();
        try{
            resJson =userInfoService.delete(donUserInfoEntityList);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_DEL);
        }
        return resJson;
    }
}
