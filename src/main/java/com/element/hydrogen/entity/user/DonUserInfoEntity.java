package com.element.hydrogen.entity.user;

import com.element.hydrogen.entity.common.PageResultEntity;
import lombok.*;

import java.util.Date;

/**
 * @ClassName DonUserInfoEntity
 * @Description 用户信息表Entity
 * @Author yanyu
 * @Date 2022/1/28 18:56
 * @Version 1.0
 */
@Data
public class DonUserInfoEntity extends PageResultEntity {
    private String userId;

    private String userName;

    private String nickname;

    private String userForeignName;

    private String sex;

    private String birthday;

    private String phoneNo;

    private String email;

    private String address;

    private String avatar;

    private String userStatus;

    private String remark;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String donUserInfoId;

}
