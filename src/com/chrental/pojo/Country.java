package com.chrental.pojo;

import java.sql.Date;

public class Country {

	private long ID;
	private String name;
	private String code;
	private String tripleCode;
	private int order;
	private Date createDate;
	private boolean isActive;
	
	public Country(){
		
	}
	
	public Country(int ID, String name) {
		this.ID = ID;
		this.name = name;
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

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
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
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
