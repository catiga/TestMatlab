package com.smartgrid.response;

public class ProtObj {

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
}
