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
    private String message;

    /**
     * 返回结果
     */
    private T result;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ResponseJson [code=" + code + ", status=" + status + ", message=" + message + ", result=" + result
				+ "]";
	}

}

