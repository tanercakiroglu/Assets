package com.chrental.pojo;

import java.sql.Date;

public class Country {

	private long ID;
	private String name;
	private String code;
	private String tripleCode;
	private int order;
	private Date createDate;
	private boolean active;
	private String phoneCode;
	
	public Country(){
		
	}
	
	
	
	public Country(long ID, String name, String code, String tripleCode, int order, Date createDate, boolean isActive,
			String phoneCode) {
		this.ID=ID;
		this.name = name;
		this.code = code;
		this.tripleCode = tripleCode;
		this.order = order;
		this.createDate = createDate;
		this.active = isActive;
		this.phoneCode = phoneCode;
	}



	public long getId() {
		return ID;
	}
	public void setId(long ID) {
		this.ID = ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTripleCode() {
		return tripleCode;
	}

	public void setTripleCode(String tripleCode) {
		this.tripleCode = tripleCode;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}
	
	
	
}
