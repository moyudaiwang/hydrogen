package com.element.hydrogen.entity.book;

import com.element.hydrogen.entity.common.PageResultEntity;

import java.util.Date;
/**
 * @ClassName BookInfoEntity
 * @Description TODO
 * @Author yanyu
 * @Date 2020/11/10 22:08
 * @Version 1.0
 */
public class BookInfoEntity extends PageResultEntity {
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

    public String getDonBookInfoId() {
        return donBookInfoId;
    }

    public void setDonBookInfoId(String donBookInfoId) {
        this.donBookInfoId = donBookInfoId == null ? null : donBookInfoId.trim();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getIsbnPid() {
        return isbnPid;
    }

    public void setIsbnPid(String isbnPid) {
        this.isbnPid = isbnPid == null ? null : isbnPid.trim();
    }

    public String getIsbnSid() {
        return isbnSid;
    }

    public void setIsbnSid(String isbnSid) {
        this.isbnSid = isbnSid == null ? null : isbnSid.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookForeignName() {
        return bookForeignName;
    }

    public void setBookForeignName(String bookForeignName) {
        this.bookForeignName = bookForeignName == null ? null : bookForeignName.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getAuthorForeignName() {
        return authorForeignName;
    }

    public void setAuthorForeignName(String authorForeignName) {
        this.authorForeignName = authorForeignName == null ? null : authorForeignName.trim();
    }

    public String getAuthorCountry() {
        return authorCountry;
    }

    public void setAuthorCountry(String authorCountry) {
        this.authorCountry = authorCountry == null ? null : authorCountry.trim();
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator == null ? null : translator.trim();
    }

    public String getTranslatorForeignName() {
        return translatorForeignName;
    }

    public void setTranslatorForeignName(String translatorForeignName) {
        this.translatorForeignName = translatorForeignName == null ? null : translatorForeignName.trim();
    }

    public String getEditorCharge() {
        return editorCharge;
    }

    public void setEditorCharge(String editorCharge) {
        this.editorCharge = editorCharge == null ? null : editorCharge.trim();
    }

    public String getCoverDesign() {
        return coverDesign;
    }

    public void setCoverDesign(String coverDesign) {
        this.coverDesign = coverDesign == null ? null : coverDesign.trim();
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection == null ? null : collection.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue == null ? null : issue.trim();
    }

    public String getPrintHouse() {
        return printHouse;
    }

    public void setPrintHouse(String printHouse) {
        this.printHouse = printHouse == null ? null : printHouse.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType == null ? null : currencyType.trim();
    }

    public String getEditionFirstDate() {
        return editionFirstDate;
    }

    public void setEditionFirstDate(String editionFirstDate) {
        this.editionFirstDate = editionFirstDate == null ? null : editionFirstDate.trim();
    }

    public String getImpressionFirstDate() {
        return impressionFirstDate;
    }

    public void setImpressionFirstDate(String impressionFirstDate) {
        this.impressionFirstDate = impressionFirstDate == null ? null : impressionFirstDate.trim();
    }

    public String getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(String editionDate) {
        this.editionDate = editionDate == null ? null : editionDate.trim();
    }

    public String getImpressionDate() {
        return impressionDate;
    }

    public void setImpressionDate(String impressionDate) {
        this.impressionDate = impressionDate == null ? null : impressionDate.trim();
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition == null ? null : edition.trim();
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression == null ? null : impression.trim();
    }

    public String getSheetsNum() {
        return sheetsNum;
    }

    public void setSheetsNum(String sheetsNum) {
        this.sheetsNum = sheetsNum == null ? null : sheetsNum.trim();
    }

    public String getBookFormat() {
        return bookFormat;
    }

    public void setBookFormat(String bookFormat) {
        this.bookFormat = bookFormat == null ? null : bookFormat.trim();
    }

    public String getWordNum() {
        return wordNum;
    }

    public void setWordNum(String wordNum) {
        this.wordNum = wordNum == null ? null : wordNum.trim();
    }

    public String getBookPage() {
        return bookPage;
    }

    public void setBookPage(String bookPage) {
        this.bookPage = bookPage == null ? null : bookPage.trim();
    }

    public String getPrintNumStart() {
        return printNumStart;
    }

    public void setPrintNumStart(String printNumStart) {
        this.printNumStart = printNumStart == null ? null : printNumStart.trim();
    }

    public String getPrintNumEnd() {
        return printNumEnd;
    }

    public void setPrintNumEnd(String printNumEnd) {
        this.printNumEnd = printNumEnd == null ? null : printNumEnd.trim();
    }

    public String getPrintNum() {
        return printNum;
    }

    public void setPrintNum(String printNum) {
        this.printNum = printNum == null ? null : printNum.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getClc() {
        return clc;
    }

    public void setClc(String clc) {
        this.clc = clc == null ? null : clc.trim();
    }

    public String getFlc() {
        return flc;
    }

    public void setFlc(String flc) {
        this.flc = flc == null ? null : flc.trim();
    }

    public String getBindType() {
        return bindType;
    }

    public void setBindType(String bindType) {
        this.bindType = bindType == null ? null : bindType.trim();
    }

    public String getLwh() {
        return lwh;
    }

    public void setLwh(String lwh) {
        this.lwh = lwh == null ? null : lwh.trim();
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume == null ? null : volume.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getSignFlag() {
        return signFlag;
    }

    public void setSignFlag(String signFlag) {
        this.signFlag = signFlag == null ? null : signFlag.trim();
    }

    public String getSignetFlag() {
        return signetFlag;
    }

    public void setSignetFlag(String signetFlag) {
        this.signetFlag = signetFlag == null ? null : signetFlag.trim();
    }

    public String getBookAvatar() {
        return bookAvatar;
    }

    public void setBookAvatar(String bookAvatar) {
        this.bookAvatar = bookAvatar == null ? null : bookAvatar.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
