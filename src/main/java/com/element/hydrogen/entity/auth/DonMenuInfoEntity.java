package com.element.hydrogen.entity.auth;

import com.element.hydrogen.entity.common.PageResultEntity;
import lombok.*;

import java.util.Date;

/**
 * @author yanyu
 */
@Data
public class DonMenuInfoEntity extends PageResultEntity {
    private String donMenuInfoId;

    private String menuId;

    private String menuPid;

    private String menuName;

    private String menuStatus;

    private String remark;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

}