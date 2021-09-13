package com.bean;

public class FacultyTimesheet {
	private int faculty_facultyid;
	private String faculty_name;
	private String faculty_stream;
	private String faculty_designation;
	
	
	private int timesheet_timesheetid;
	private String timesheet_taskname;
	private String timesheet_date;
	private int timesheet_hrsworked;
	private String timesheet_taskdescription;
	private int timesheet_facultyid;
	public int getFaculty_facultyid() {
		return faculty_facultyid;
	}
	public void setFaculty_facultyid(int faculty_facultyid) {
		this.faculty_facultyid = faculty_facultyid;
	}
	public String getFaculty_name() {
		return faculty_name;
	}
	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}
	public String getFaculty_stream() {
		return faculty_stream;
	}
	public void setFaculty_stream(String faculty_stream) {
		this.faculty_stream = faculty_stream;
	}
	public String getFaculty_designation() {
		return faculty_designation;
	}
	public void setFaculty_designation(String faculty_designation) {
		this.faculty_designation = faculty_designation;
	}
	public int getTimesheet_timesheetid() {
		return timesheet_timesheetid;
	}
	public void setTimesheet_timesheetid(int timesheet_timesheetid) {
		this.timesheet_timesheetid = timesheet_timesheetid;
	}
	public String getTimesheet_taskname() {
		return timesheet_taskname;
	}
	public void setTimesheet_taskname(String timesheet_taskname) {
		this.timesheet_taskname = timesheet_taskname;
	}
	public String getTimesheet_date() {
		return timesheet_date;
	}
	public void setTimesheet_date(String timesheet_date) {
		this.timesheet_date = timesheet_date;
	}
	public int getTimesheet_hrsworked() {
		return timesheet_hrsworked;
	}
	public void setTimesheet_hrsworked(int timesheet_hrsworked) {
		this.timesheet_hrsworked = timesheet_hrsworked;
	}
	public String getTimesheet_taskdescription() {
		return timesheet_taskdescription;
	}
	public void setTimesheet_taskdescription(String timesheet_taskdescription) {
		this.timesheet_taskdescription = timesheet_taskdescription;
	}
	public int getTimesheet_facultyid() {
		return timesheet_facultyid;
	}
	public void setTimesheet_facultyid(int timesheet_facultyid) {
		this.timesheet_facultyid = timesheet_facultyid;
	}
	public FacultyTimesheet() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
