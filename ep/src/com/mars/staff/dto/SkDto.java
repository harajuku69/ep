package com.mars.staff.dto;

import java.sql.Timestamp;
import java.util.List;

public class SkDto {
	private int 			skno;
	private String 			empid;
	private List<String>	skList;
	private Timestamp		regdt;
	
	public int getSkno() {
		return skno;
	}
	public void setSkno(int skno) {
		this.skno = skno;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public List<String> getSkList() {
		return skList;
	}
	public void setSkList(List<String> skList) {
		this.skList = skList;
	}
	public Timestamp getRegdt() {
		return regdt;
	}
	public void setRegdt(Timestamp regdt) {
		this.regdt = regdt;
	}
	@Override
	public String toString() {
		return "SkDto [skno=" + skno + ", empid=" + empid + ", skList=" + skList + ", regdt=" + regdt + "]";
	}
}
