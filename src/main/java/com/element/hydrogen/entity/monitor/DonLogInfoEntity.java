package com.element.hydrogen.entity.monitor;

import com.element.hydrogen.entity.common.PageResultEntity;
import lombok.*;
import java.util.Date;

/**
 * @author yanyu
 */
@Data
public class DonLogInfoEntity extends PageResultEntity {
    private String donLogInfoId;

    private String logId;

    private String ip;

    private String roleId;

    private String userId;

    private String roleName;

    private String userName;

    private String operateType;

    private Date operateDate;

    private String firstModule;

    private String secondModule;

    private String thirdModule;

    private String usePoint;

    private String operateResult;

    private String eventScene;

    private String remark;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

}