package com.my.vo;

import java.util.Date;

public class Customer {
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private Date   reg_dt;
	private int status;
	//매개변수없는 생성자 추가
	public Customer() {
		super();
	}
	
	//매개변수id, pwd,name초기화하는 생성자 추가
	public Customer(String id, String pwd, String name) {
		this(id,pwd,name, null, null, 0);
	}
	
	public Customer(String id, String pwd, String name, String gender, Date reg_dt, int status) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.reg_dt = reg_dt;
		this.status = status;
	}

	@Override
	public String toString() {
		return "id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", reg_dt=" + reg_dt
				+ ", status=" + status;
	}

	public String getId() {
		return id;
	}
	
	

	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
