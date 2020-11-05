package com.element.hydrogen.entity.common;

import java.util.List;

/**
 * @ClassName PageResultEntity
 * @Description 分页返回结果
 * @Author yanyu
 * @Date 2020/8/30 2:24
 * @Version 1.0
 */
public class PageResultEntity {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据模型
     */
    private List<?> content;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 操作时间
     */
    private String operatorDate;

    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public long getTotalSize() {
        return totalSize;
    }
    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public List<?> getContent() {
        return content;
    }
    public void setContent(List<?> content) {
        this.content = content;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    public String getOperatorDate() {
        return operatorDate;
    }
    public void setOperatorDate(String operatorDate) {
        this.operatorDate = operatorDate;
    }
}
