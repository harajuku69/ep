package com.mars.staff.dto;

import java.sql.Timestamp;

public class SkDto {
	private int 		skno;
	private String 		empid;
	private String		skcd;
	private Timestamp	regdt;
	
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
	public String getSkcd() {
		return skcd;
	}
	public void setSkcd(String skcd) {
		this.skcd = skcd;
	}
	public Timestamp getRegdt() {
		return regdt;
	}
	public void setRegdt(Timestamp regdt) {
		this.regdt = regdt;
	}
	@Override
	public String toString() {
		return "SkDto [skno=" + skno + ", empid=" + empid + ", skcd=" + skcd + ", regdt=" + regdt + "]";
	}
}
