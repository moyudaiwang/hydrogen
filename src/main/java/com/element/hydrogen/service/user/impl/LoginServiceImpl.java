package com.element.hydrogen.service.user.impl;

import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.auth.DonAccountInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.mapper.auth.DonAccountInfoMapper;
import com.element.hydrogen.service.user.LoginService;
import com.element.hydrogen.utils.common.math.LogicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Author yanyu
 * @Date 2021/1/30 17:29
 * @Version 1.0
 */
@Service
public class LoginServiceImpl  implements LoginService {

    @Autowired
    private DonAccountInfoMapper donAccountInfoMapper;

    /**
     * 登录
     * @param queryEntity
     * @return
     */
    @Override
    public ResponseJson login(DonAccountInfoEntity queryEntity) {
        ResponseJson responseJson= new ResponseJson();
        responseJson.setOkay(false);
        responseJson.setCode(ResponseJsonConstant.FAIL);
        List<DonAccountInfoEntity> entityList = new ArrayList<DonAccountInfoEntity>();
        DonAccountInfoEntity entity = new DonAccountInfoEntity();
        //判断账号是用户Id/手机号/邮箱
        if (checkAlien(queryEntity)){
            entityList = donAccountInfoMapper.query(queryEntity);
        }else {
            responseJson.setMsg("账号不存在");
            return responseJson;
        }

        if(entityList.size()>0 && (entityList.get(0).getUserId().equals(queryEntity.getAlien()) ||
                entityList.get(0).getPhoneNo().equals(queryEntity.getAlien()) ||
                entityList.get(0).getEmail().equals(queryEntity.getAlien()))){
            entity =entityList.get(0);
            if (LogicUtil.noEmpty(entity.getPwd())) {
                if (queryEntity.getPwd().equals(entity.getPwd())) {
                    if ("Y".equals(entity.getAccountStatus())){
                        responseJson.setOkay(true);
                        responseJson.setCode(ResponseJsonConstant.SUCCESS);
                        responseJson.setObject(entity);
                        responseJson.setMsg("登录成功");
                        return responseJson;
                    }else {
                        responseJson.setMsg("该账号已锁定");
                    }
                }else {
                    responseJson.setMsg("密码错误");
                }
            }else{
                responseJson.setMsg("请输入密码");
            }
        }else {
            responseJson.setMsg("账号未注册");
        }
        return responseJson;
    }

    /**
     * 注册
     * @param param
     * @return
     */
    @Override
    public ResponseJson register(DonAccountInfoEntity param) {
        ResponseJson responseJson= new ResponseJson();
        responseJson.setOkay(false);
        responseJson.setCode(ResponseJsonConstant.FAIL);
        switch (param.getAlienType()){
            case 1:
                param.setUserId(param.getAlien());
                break;
            case 2:
                param.setPhoneNo(param.getAlien());
                break;
            case 3:
                param.setEmail(param.getAlien());
                break;
        }
        int num = donAccountInfoMapper.check(param);
        if (num>0){
            responseJson.setMsg("用户ID/手机号/邮箱已存在，注册失败");
            return responseJson;
        }
        int count = donAccountInfoMapper.insert(param);
        if (count==1){
            responseJson.setOkay(true);
            responseJson.setCode(ResponseJsonConstant.SUCCESS);
            responseJson.setMsg("注册成功");
        }else {
            responseJson.setMsg("注册失败");
        }
        return responseJson;
    }

    /**
     * 获取验证码
     * @param donAccountInfoEntity
     * @return
     */
    @Override
    public ResponseJson receiveCode(DonAccountInfoEntity donAccountInfoEntity) {
        //账号是否存在
        //账密是否正确
        //账号是否已登录
        //账密是否已达到失败上限
        ResponseJson responseJson = login(donAccountInfoEntity);
        if (responseJson.isOkay()){

        }
        //上一验证码是否失效
        //发送验证码
        return null;
    }


    //验证验证码
    private boolean checkCaptcha(DonAccountInfoEntity donAccountInfoEntityByResult, ResponseJson responseJson) {

        return true;
    }


    //验证账号状态
    private boolean checkAccountStatus(DonAccountInfoEntity donAccountInfoEntityByResult, ResponseJson responseJson) {
/*        //验证账号状态
        if (checkAccountStatus(entity,responseJson)){
            //验证验证码
            if (checkCaptcha(entity,responseJson)){
                //验证验证码CAPTCHA
                //todo yyf
                responseJson.setOkay(true);
                responseJson.setCode(ResponseJsonConstant.SUCCESS);
                responseJson.setMsg("登录成功");
                return responseJson;
            }else {
                //todo yyf
                //return responseJson;
            }
        }else {
            return responseJson;
        }
        if(entity != null){
            if (LogicUtil.noEmpty(entity.getPwd())) {
                if (donAccountInfoEntity.getPwd().equals(entity.getPwd())) {
                    if ("Y".equals(entity.getAccountStatus())){
                        //TODO YYF
                        if (1==1){
                            responseJson.setOkay(true);
                            responseJson.setCode(ResponseJsonConstant.SUCCESS);
                            responseJson.setMsg("登录成功");
                            return responseJson;
                        }else {
                            responseJson.setCode(ResponseJsonConstant.FAIL);
                            responseJson.setMsg("验证码未失效，稍后重试");
                        }
                    }else {
                        responseJson.setCode(ResponseJsonConstant.FAIL);
                        responseJson.setMsg("该账号已锁定");
                    }
                }else {
                    responseJson.setCode(ResponseJsonConstant.FAIL);
                    responseJson.setMsg("密码错误");
                }
            }else{
                responseJson.setCode(ResponseJsonConstant.FAIL);
                responseJson.setMsg("请输入密码");
            }
        }else {
            responseJson.setCode(ResponseJsonConstant.FAIL);
            responseJson.setMsg("账号未注册");
        }*/

        //账号是否存在
        //账密是否正确
        //账号是否已登录
        //账密是否已达到失败上限
        return true;
        //ResponseJson responseJson = check(donAccountInfoEntity);
        //todo yyf
        /*if ("Y".equals(donAccountInfoEntityByResult.getAccountStatus())){
            return true;
        }else {
            responseJson.setCode(ResponseJsonConstant.FAIL);
            responseJson.setMsg("该账号已锁定");
            //todo yyf
            return true;
        }*/
        //上一验证码是否失效
        //发送验证码
    }


    /**
     * 判断账号是userId/手机号/邮箱
     * @param donAccountInfoEntity
     * @return
     */
    private boolean checkAlien(DonAccountInfoEntity donAccountInfoEntity) {
        String account =donAccountInfoEntity.getAlien();
        donAccountInfoEntity.setAlienVerify(false);
        if (LogicUtil.noEmpty(account)) {
            if(checkUserId(donAccountInfoEntity)){
                donAccountInfoEntity.setAlienVerify(true);
                return true;
            }
            if(checkPhoneNo(donAccountInfoEntity)){
                donAccountInfoEntity.setAlienVerify(true);
                return true;
            }
            if(checkEmail(donAccountInfoEntity)){
                donAccountInfoEntity.setAlienVerify(true);
                return true;
            }
        }else{
            donAccountInfoEntity.setMsg("账号为空");
        }
        return false;
    }

    //用户名验证：大小写字母和数字下划线,6-20位
    private boolean checkUserId(DonAccountInfoEntity donAccountInfoEntity) {
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z_]{6,20}$";
        if (donAccountInfoEntity.getAlien().matches(regex)){
            donAccountInfoEntity.setUserId(donAccountInfoEntity.getAlien());
            return true;
        }
        return false;
    }

    //手机验证
    private boolean checkPhoneNo(DonAccountInfoEntity donAccountInfoEntity) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (donAccountInfoEntity.getAlien().length() == 11) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(donAccountInfoEntity.getAlien());
            if (m.matches()){
                donAccountInfoEntity.setPhoneNo(donAccountInfoEntity.getAlien());
                return true;
            }
        }
        return false;
    }

    //email验证
    private boolean checkEmail(DonAccountInfoEntity donAccountInfoEntity) {
        String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(donAccountInfoEntity.getAlien());
        if (m.matches()){
            donAccountInfoEntity.setEmail(donAccountInfoEntity.getAlien());
            return true;
        }
        return false;
    }

}
