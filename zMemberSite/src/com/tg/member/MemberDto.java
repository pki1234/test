package com.tg.member;

import java.util.Date;

public class MemberDto {
	
	//DTO는 로직을 가지지 않는 순수한 데이터 객체이고 getter, setter 메소드만 가진 클래스를 의미.
	//DTO와 VO의 공통점은 넣어진 데이터를 getter를 통해 사용하므로 주 목적은 같습니다. 
	//그러나 DTO의 경우는 가변의 성격을 가진 클래스 입니다(setter 활용). 
	//그에반해 VO는 불변의 성격을 가졌기에 차이점이 있습니다. 
	
	private	int no = 0;              
	private	String name = ""; 
	private	String email = ""; 
	private	String password = ""; 
	private	Date createDate = null;
	private	Date modifiedDate = null;
	
	public MemberDto() {
		super();
	}
	
	public MemberDto(int no, String name, String email, Date createDate) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.createDate = createDate;
	}
	
	public MemberDto(int no, String name, String email,String pwd, Date createDate) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.password=pwd;
		this.createDate = createDate;
	}
	public MemberDto(int no, String name, String email, String password, Date createDate, Date modifiedDate) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.password = password;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
}
