package com.web.info.system;

/**
 * 请求返回实体
 * 
 * @author Administrator
 * 
 */
public class ReturnStandard {

	private Integer code;

	private String msg;

	private Object data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
