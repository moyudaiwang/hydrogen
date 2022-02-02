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
    public static ResponseJsonConstant res;

    @Override
    public ResponseJson check(DonAccountInfoEntity donAccountInfoEntity) {
        ResponseJson responseJson= new ResponseJson();
        List<DonAccountInfoEntity> donAccountInfoEntityList = new ArrayList<DonAccountInfoEntity>();
        //判断账号是用户名/userId/手机号/邮箱
        String result = checkAccount(donAccountInfoEntity);
        donAccountInfoEntityList = donAccountInfoMapper.query(donAccountInfoEntity);
        for (DonAccountInfoEntity entity:donAccountInfoEntityList) {
            if (LogicUtil.noEmpty(entity.getPwd())) {
                if (entity.getPwd().equals(donAccountInfoEntity.getPwd())) {
                    responseJson.setCode(res.SUCCESS);
                    responseJson.setMsg("登录成功");
                    return responseJson;
                }else {
                    responseJson.setCode(res.FAIL);
                    responseJson.setMsg("密码错误");
                }
            }else{
                responseJson.setCode(res.FAIL);
                responseJson.setMsg("请输入密码");;
            }
        }
        return responseJson;
    }

    /**
     * 判断账号是用户名/userId/手机号/邮箱
     * @param donAccountInfoEntity
     * @return
     */
    private String checkAccount(DonAccountInfoEntity donAccountInfoEntity) {
        String result ="";
        String account =donAccountInfoEntity.getAccount();
        if (LogicUtil.noEmpty(account)) {
            checkUserId(donAccountInfoEntity);
            checkPhoneNo(donAccountInfoEntity);
            checkEmail(donAccountInfoEntity);
        }else{
            System.out.println("账号为空");
        }
        return  result;
    }

    //用户名验证：大小写字母和数字下划线,6-20位
    private void checkUserId(DonAccountInfoEntity donAccountInfoEntity) {
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z_]{6,20}$";
        if (donAccountInfoEntity.getAccount().matches(regex)){
            donAccountInfoEntity.setUserId(donAccountInfoEntity.getAccount());
        }
    }

    //手机验证
    private void checkPhoneNo(DonAccountInfoEntity donAccountInfoEntity) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (donAccountInfoEntity.getAccount().length() == 11) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(donAccountInfoEntity.getAccount());
            if (m.matches()){
                donAccountInfoEntity.setPhoneNo(donAccountInfoEntity.getAccount());
            }
        }

    }

    //email验证
    private void checkEmail(DonAccountInfoEntity donAccountInfoEntity) {
        String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(donAccountInfoEntity.getAccount());
        if (m.matches()){
            donAccountInfoEntity.setEmail(donAccountInfoEntity.getAccount());
        }
    }

}
