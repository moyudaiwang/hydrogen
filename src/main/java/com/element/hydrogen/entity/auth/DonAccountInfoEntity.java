package com.element.hydrogen.entity.auth;

import com.element.hydrogen.entity.common.PageResultEntity;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName DonAccountInfoEntity
 * @Description 账号信息表Entity
 * @Author yanyu
 * @Date 2022/1/28 18:58
 * @Version 1.0
 */
@Data
public class DonAccountInfoEntity extends PageResultEntity {
    private String donAccountInfoId;

    private String accountId;

    private String userId;

    private String userName;

    private String phoneNo;

    private String email;

    private String alg;

    private String userKey;

    private String pwd;

    private String captcha;

    private Date captchaTime;

    private String errorNum;

    private String initPwd;

    private String accountStatus;

    private String remark;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    /**
     * 登录：待验证账号
     */
    private String alien;

    /**
     * 登录：登录提示信息
     */
    private String msg;
    /**
     * 登录：登录提示信息
     */
    private boolean alienVerify;

    /**
     * 登录：登录提示信息
     */
    private int alienType;


}
