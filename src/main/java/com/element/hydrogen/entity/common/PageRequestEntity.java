package com.element.hydrogen.entity.common;

/**
 * @ClassName PageRequestEntity
 * @Description 分页请求
 * @Author yanyu
 * @Date 2020/8/30 2:23
 * @Version 1.0
 */
public class PageRequestEntity {

    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;

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
}
