package com.element.hydrogen.entity.map;

import com.element.hydrogen.entity.common.PageResultEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 韦力寻访地图
 */
@Data
public class DonWlxfMapEntity extends PageResultEntity implements Serializable {
    private String donWlxfMapId;

    private String bookName;

    private String title;

    private String hero;

    private String landmark;

    private String times;

    private String urban;

    private String address;

    private String relHero;

    private String relLandmark;

    private String relBook;

    private String companion;

    private String searchTime;

    private String tickets;

    private String anecdote;

    private String x;

    private String y;

    private String z;

    private String mapStatus;

    private String remark;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

}