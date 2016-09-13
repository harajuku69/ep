package com.mars.staff.dto;

import java.sql.Timestamp;

public class EduDto {
	private String 		empid;
	private int 		eduno;
	private String 		loc;
	private String 		school;
	private String 		major;
	private Timestamp 	enterdt;
	private Timestamp 	graddt;
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public int getEduno() {
		return eduno;
	}
	public void setEduno(int eduno) {
		this.eduno = eduno;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Timestamp getEnterdt() {
		return enterdt;
	}
	public void setEnterdt(Timestamp enterdt) {
		this.enterdt = enterdt;
	}
	public Timestamp getGraddt() {
		return graddt;
	}
	public void setGraddt(Timestamp graddt) {
		this.graddt = graddt;
	}
	@Override
	public String toString() {
		return "EduDto [empid=" + empid + ", eduno=" + eduno + ", loc=" + loc + ", school=" + school + ", major="
				+ major + ", enterdt=" + enterdt + ", graddt=" + graddt + "]";
	}
}
