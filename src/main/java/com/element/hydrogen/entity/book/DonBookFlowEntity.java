package com.element.hydrogen.entity.book;

import com.element.hydrogen.entity.common.PageResultEntity;
import lombok.*;
import java.util.Date;

@Data
public class DonBookFlowEntity extends PageResultEntity {
    private String donBookFlowId;

    private String bookId;

    private String isbn;

    private String isbnPid;

    private String isbnSid;

    private String bookName;

    private String bookForeignName;

    private Date visionDate;

    private String visionMan;

    private String visionGroup;

    private String shopPrice;

    private String shopGrade;

    private String shopMan;

    private String shopPlatform;

    private String shopAddress;

    private String shopUnit;

    private Date shopDate;

    private String shopAim;

    private String collector;

    private String collectionAddress;

    private String rackNum;

    private Date exportDate;

    private String exportMan;

    private String exportPrice;

    private String exportGrade;

    private String receivingUnit;

    private Date planHomewardDate;

    private String planHomewardAddress;

    private Date homewardDate;

    private String homewardAddress;

    private String homewardMan;

    private String bookStatus;

    private String remark;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

}