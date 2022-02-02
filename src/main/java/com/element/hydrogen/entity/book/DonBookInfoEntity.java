package com.element.hydrogen.entity.book;

import com.element.hydrogen.entity.common.PageResultEntity;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName DonBookInfoEntity
 * @Description TODO
 * @Author yanyu
 * @Date 2022/1/29 3:03
 * @Version 1.0
 */
@Data
public class DonBookInfoEntity extends PageResultEntity {
    private String donBookInfoId;

    private String bookId;

    private String isbn;

    private String isbnPid;

    private String isbnSid;

    private String bookName;

    private String bookForeignName;

    private String author;

    private String authorForeignName;

    private String authorCountry;

    private String translator;

    private String translatorForeignName;

    private String editorCharge;

    private String coverDesign;

    private String collection;

    private String press;

    private String issue;

    private String printHouse;

    private String price;

    private String currencyType;

    private String editionFirstDate;

    private String impressionFirstDate;

    private String editionDate;

    private String impressionDate;

    private String edition;

    private String impression;

    private String sheetsNum;

    private String bookFormat;

    private String wordNum;

    private String bookPage;

    private String printNumStart;

    private String printNumEnd;

    private String printNum;

    private String language;

    private String clc;

    private String flc;

    private String bindType;

    private String lwh;

    private String volume;

    private String weight;

    private String signFlag;

    private String signetFlag;

    private String bookAvatar;

    private String remark;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

}
