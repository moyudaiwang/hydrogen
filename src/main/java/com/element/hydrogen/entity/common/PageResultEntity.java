package com.element.hydrogen.entity.common;

import lombok.Data;

import java.util.List;

/**
 * @ClassName PageResultEntity
 * @Description 分页返回结果
 * @Author yanyu
 * @Date 2020/8/30 2:24
 * @Version 1.0
 */
@Data
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

    /**
     * 查询参数
     */
    private String queryName;

}
