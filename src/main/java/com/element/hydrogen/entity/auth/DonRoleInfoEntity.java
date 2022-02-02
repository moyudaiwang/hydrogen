package com.element.hydrogen.entity.auth;

import com.element.hydrogen.entity.common.PageResultEntity;
import lombok.Data;

import java.util.Date;

/**
 * @author yanyu
 */
@Data
public class DonRoleInfoEntity extends PageResultEntity {
    private String donRoleInfoId;

    private String roleId;

    private String roleType;

    private String roleName;

    private String roleStatus;

    private String remark;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;
 }