package com.bean;



public class Employee {
	private int eid;
	private String name;
	private String gender;
	private String address;
	private int ssnNo;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSsnNo() {
		return ssnNo;
	}
	public void setSsnNo(int ssnNo) {
		this.ssnNo = ssnNo;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", gender=" + gender
				+ ", address=" + address + ", ssnNo=" + ssnNo + "]";
	}
	public Employee(int eid, String name, String gender, String address,
			int ssnNo) {
		super();
		this.eid = eid;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.ssnNo = ssnNo;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}