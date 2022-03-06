package com.element.hydrogen.entity.graph;

import com.element.hydrogen.entity.common.PageResultEntity;
import lombok.Data;

import java.util.Date;

@Data
public class DonHlmInfoEntity extends PageResultEntity {
    private String donHlmInfoId;

    private String userId;

    private String userName;

    private String nickname;

    private String sex;

    private String age;

    private String userType;

    private String profile;

    private String address;

    private String clan;

    private String userLevel;

    private String debut;

    private String userAttributes;

    private String avatar;

    private String userStatus;

    private String remark;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

}