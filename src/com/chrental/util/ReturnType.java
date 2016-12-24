package com.chrental.util;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class ReturnType {

	private Object returnDataObject;
	private String tag;
	private boolean status;
	
	
	public ReturnType(Object returnDataObject, String tag, boolean status) {
		this.returnDataObject = returnDataObject;
		this.tag = tag;
		this.status = status;
	}
	public Object getReturnDataObject() {
		return returnDataObject;
	}
	public void setReturnDataObject(Object returnDataObject) {
		this.returnDataObject = returnDataObject;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
