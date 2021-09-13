package com.bean;

public class Emp {
	private int id;
	private String name;
	private int ssnNo;
	private String Address;
	private double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSsnNo() {
		return ssnNo;
	}
	public void setSsnNo(int ssnNo) {
		this.ssnNo = ssnNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Emp(int id, String name, int ssnNo, String address, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.ssnNo = ssnNo;
		Address = address;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", ssnNo=" + ssnNo
				+ ", Address=" + Address + ", salary=" + salary + "]";
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
