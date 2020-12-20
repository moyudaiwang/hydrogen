package com.element.hydrogen.entity.common;


import lombok.*;

import java.io.Serializable;


/**
 * @author yanyu
 */
@ToString
@Setter
@Getter
@Data
public class ResponseJson<T>  implements Serializable {

    public static final int STATUS_SUCCESS = 1;
    public static final int STATUS_FAILURE = 0;

    /**
     * 状态码
     */
    private String code ;

    /**
     * 返回处理状态。成功或失败
     */
    private String status ;

    /**
     * 处理结果文本描述
     */
    private String msg;

    /**
     * 返回结果
     */
    private T result;

	/**
	 * 返回对象
	 */
	private Object object;



}

