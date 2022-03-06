package com.element.hydrogen.entity.graph;

import com.element.hydrogen.entity.common.PageResultEntity;
import lombok.Data;

import java.util.Date;

@Data
public class DonHlmRelEntity extends PageResultEntity {
    private String donHlmRelId;

    private String relId;

    private String fromId;

    private String toId;

    private String relName;

    private String relType;

    private String relLevel;

    private String relStatus;

    private String remark;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;
}