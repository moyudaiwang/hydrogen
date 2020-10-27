package com.element.hydrogen.entity.common;

import java.util.List;

/**
 * @ClassName PageResult
 * @Description TODO
 * @Author yanyu
 * @Date 2020/8/30 2:49
 * @Version 1.0
 */
public class PageResult<T> {

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
}
