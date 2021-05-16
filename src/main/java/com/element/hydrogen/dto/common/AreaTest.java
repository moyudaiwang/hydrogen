package com.element.hydrogen.dto.common;

import java.io.Serializable;

/**
 * @ClassName AreaTest
 * @Description 用于整理省市县等级顺序
 * @Author yanyu
 * @Date 2021/2/28 22:33
 * @Version 1.0
 */
public class AreaTest implements Serializable {

    //每天的标题
    private String id;

    //每天的标题
    private String pid;

    //每天的标题
    private String areaLevel;
    //代办事项的数量
    private String areaName;

    private String areaCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(String areaLevel) {
        this.areaLevel = areaLevel;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        return "AreaTest{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", areaLevel='" + areaLevel + '\'' +
                ", areaName='" + areaName + '\'' +
                ", areaCode='" + areaCode + '\'' +
                '}';
    }
}
