package com.model.servlets;

public class StudentsInfoBean 
{
  private int regno;
  private String firstname;
  private String middlename;
  private String lastname;
  private String gfirstname;
  private String gmiddlename;
  private String glastname;
  private int password;
  private String isadmin;
public int getRegno() {
	return regno;
}
public void setRegno(int regno) {
	this.regno = regno;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getMiddlename() {
	return middlename;
}
public void setMiddlename(String middlename) {
	this.middlename = middlename;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getGfirstname() {
	return gfirstname;
}
public void setGfirstname(String gfirstname) {
	this.gfirstname = gfirstname;
}
public String getGmiddlename() {
	return gmiddlename;
}
public void setGmiddlename(String gmiddlename) {
	this.gmiddlename = gmiddlename;
}
public String getGlastname() {
	return glastname;
}
public void setGlastname(String glastname) {
	this.glastname = glastname;
}
public int getPassword() {
	return password;
}
public void setPassword(int password) {
	this.password = password;
}
public String getIsadmin() {
	return isadmin;
}
public void setIsadmin(String isadmin) {
	this.isadmin = isadmin;
}
  
	//make a constructor of public StudentsInfoBean
	public StudentsInfoBean()
	{
		
	}
}
