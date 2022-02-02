package com.element.hydrogen.controller.web.auth;

import cn.hutool.http.server.HttpServerRequest;
import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.auth.DonRoleInfoEntity;
import com.element.hydrogen.service.auth.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName RoleInfoController
 * @Description 角色信息
 * @Author yanyu
 * @Date 2022-02-03 02:51:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/roleInfo")
public class RoleInfoController {

    @Autowired
    private RoleInfoService roleInfoService;

    public static ResponseJsonConstant res;

    @CrossOrigin
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ResponseJson query(@RequestBody DonRoleInfoEntity donRoleInfoEntity){
        return roleInfoService.query(donRoleInfoEntity);
    }

    @CrossOrigin
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseJson insert(HttpServerRequest request, @RequestBody DonRoleInfoEntity donRoleInfoEntity){
        ResponseJson resJson = new ResponseJson();
        donRoleInfoEntity.setOperator("molecule");
        try{
            resJson =roleInfoService.insert(donRoleInfoEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseJson update(HttpServerRequest request,@RequestBody DonRoleInfoEntity donRoleInfoEntity){
        ResponseJson resJson = new ResponseJson();
        donRoleInfoEntity.setOperator("molecule");
        try{
            resJson =roleInfoService.update(donRoleInfoEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseJson delete(@RequestBody List<DonRoleInfoEntity> donUserInfoEntityList){
        ResponseJson resJson = new ResponseJson();
        try{
            resJson =roleInfoService.delete(donUserInfoEntityList);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_DEL);
        }
        return resJson;
    }
}
