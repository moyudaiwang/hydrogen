package com.element.hydrogen.entity.common;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName LogEntity
 * @Description TODO
 * @Author yanyu
 * @Date 2020/12/6 23:09
 * @Version 1.0
 */
@Getter
@ToString
@Setter
@Data
public class LogInfoEntity implements Serializable {
    private static final long serialVersionUID = -6556793741331167103L;

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
    private String donLogInfoId;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public String getFirstModule() {
        return firstModule;
    }

    public void setFirstModule(String firstModule) {
        this.firstModule = firstModule;
    }

    public String getSecondModule() {
        return secondModule;
    }

    public void setSecondModule(String secondModule) {
        this.secondModule = secondModule;
    }

    public String getThirdModule() {
        return thirdModule;
    }

    public void setThirdModule(String thirdModule) {
        this.thirdModule = thirdModule;
    }

    public String getUsePoint() {
        return usePoint;
    }

    public void setUsePoint(String usePoint) {
        this.usePoint = usePoint;
    }

    public String getOperateResult() {
        return operateResult;
    }

    public void setOperateResult(String operateResult) {
        this.operateResult = operateResult;
    }

    public String getEventScene() {
        return eventScene;
    }

    public void setEventScene(String eventScene) {
        this.eventScene = eventScene;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDonLogInfoId() {
        return donLogInfoId;
    }

    public void setDonLogInfoId(String donLogInfoId) {
        this.donLogInfoId = donLogInfoId;
    }

    @Override
    public String toString() {
        return "LogInfoEntity{" +
                "logId='" + logId + '\'' +
                ", ip='" + ip + '\'' +
                ", roleId='" + roleId + '\'' +
                ", userId='" + userId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", userName='" + userName + '\'' +
                ", operateType='" + operateType + '\'' +
                ", operateDate=" + operateDate +
                ", firstModule='" + firstModule + '\'' +
                ", secondModule='" + secondModule + '\'' +
                ", thirdModule='" + thirdModule + '\'' +
                ", usePoint='" + usePoint + '\'' +
                ", operateResult='" + operateResult + '\'' +
                ", eventScene='" + eventScene + '\'' +
                ", remark='" + remark + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", updateBy='" + updateBy + '\'' +
                ", updateDate=" + updateDate +
                ", donLogInfoId='" + donLogInfoId + '\'' +
                '}';
    }
}
