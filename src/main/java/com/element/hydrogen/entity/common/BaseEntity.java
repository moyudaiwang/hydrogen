package com.element.hydrogen.entity.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName BaseEntity
 * @Description TODO
 * @Author yanyu
 * @Date 2021/6/22 22:49
 * @Version 1.0
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -8924489279354312949L;
    private Long id;
    private Long createDate = System.currentTimeMillis();
    private Long updateDate;
}
