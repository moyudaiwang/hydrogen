package com.element.hydrogen.service.user.impl;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.user.AccountCodeEntity;
import com.element.hydrogen.mapper.user.AccountCodeMapper;
import com.element.hydrogen.service.user.LoginService;
import com.element.hydrogen.utils.common.math.LogicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private AccountCodeMapper accountCodeMapper;

    @Override
    public ResponseJson check(AccountCodeEntity accountCodeEntity) {
        ResponseJson responseJson= new ResponseJson();
        AccountCodeEntity resultEntity = new AccountCodeEntity();
        //判断账号是用户名/userId/手机号/邮箱
        String result = checkAccount(accountCodeEntity);

        resultEntity = accountCodeMapper.query(accountCodeEntity);
        if (LogicUtil.noEmpty(resultEntity.getPwd())) {
            if (resultEntity.getPwd().equals(accountCodeEntity.getPwd())) {
                responseJson.setCode("200");
                responseJson.setMsg("登录成功");
            }else {
                responseJson.setCode("201");
                responseJson.setMsg("密码错误");
            }
        }else{
            responseJson.setCode("202");
            responseJson.setMsg("密码为空");;
        }
        return responseJson;
    }

    /**
     * 判断账号是用户名/userId/手机号/邮箱
     * @param accountCodeEntity
     * @return
     */
    private String checkAccount(AccountCodeEntity accountCodeEntity) {
        String result ="";
        String account =accountCodeEntity.getAccount();
        if (LogicUtil.noEmpty(account)) {
            checkUserId(accountCodeEntity);
            checkPhoneNo(accountCodeEntity);
            checkEmail(accountCodeEntity);
        }else{
            System.out.println("账号为空");
        }
        return  result;
    }

    //用户名验证：大小写字母和数字下划线,6-20位
    private void checkUserId(AccountCodeEntity accountCodeEntity) {
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z_]{6,20}$";
        if (accountCodeEntity.getAccount().matches(regex)){
            accountCodeEntity.setUserId(accountCodeEntity.getAccount());
        }
    }

    //手机验证
    private void checkPhoneNo(AccountCodeEntity accountCodeEntity) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (accountCodeEntity.getAccount().length() == 11) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(accountCodeEntity.getAccount());
            if (m.matches()){
                accountCodeEntity.setPhoneNo(accountCodeEntity.getAccount());
            }
        }

    }

    //email验证
    private void checkEmail(AccountCodeEntity accountCodeEntity) {
        String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(accountCodeEntity.getAccount());
        if (m.matches()){
            accountCodeEntity.setEmail(accountCodeEntity.getAccount());
        }
    }

}
