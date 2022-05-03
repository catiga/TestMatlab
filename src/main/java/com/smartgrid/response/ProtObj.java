package com.smartgrid.response;

import java.io.Serializable;

public class ProtObj implements Serializable {
	
	private static final long serialVersionUID = 1l;

	int errno;
	
	String errmsg;
	
	Object data;
	
	public ProtObj() {}
	
	public ProtObj(int code, String errmsg, Object data) {
		this.errmsg = errmsg;
		this.errno = code;
		this.data = data;
	}
	
	public static ProtObj success(Object data) {
		return new ProtObj(0, "", data);
	}
	
	public static ProtObj fail(int errno, String errmsg) {
		return new ProtObj(errno, errmsg, null);
	}
	
	public static ProtObj fail(int errno, String errmsg, Object data) {
		return new ProtObj(errno, errmsg, data);
	}

	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
