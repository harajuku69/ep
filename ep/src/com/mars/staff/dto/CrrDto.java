package com.mars.staff.dto;

import java.sql.Timestamp;

public class CrrDto {
	String		empid;
	int			crrno;
	String		comnm;
	String		dpt;
	String		tit;
	Timestamp	empdt;
	Timestamp	outdt;
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public int getCrrno() {
		return crrno;
	}
	public void setCrrno(int crrno) {
		this.crrno = crrno;
	}
	public String getComnm() {
		return comnm;
	}
	public void setComnm(String comnm) {
		this.comnm = comnm;
	}
	public String getDpt() {
		return dpt;
	}
	public void setDpt(String dpt) {
		this.dpt = dpt;
	}
	public String getTit() {
		return tit;
	}
	public void setTit(String tit) {
		this.tit = tit;
	}
	public Timestamp getEmpdt() {
		return empdt;
	}
	public void setEmpdt(Timestamp empdt) {
		this.empdt = empdt;
	}
	public Timestamp getOutdt() {
		return outdt;
	}
	public void setOutdt(Timestamp outdt) {
		this.outdt = outdt;
	}
	@Override
	public String toString() {
		return "CrrDto [empid=" + empid + ", crrno=" + crrno + ", comnm=" + comnm + ", dpt=" + dpt + ", tit=" + tit
				+ ", empdt=" + empdt + ", outdt=" + outdt + "]";
	}
}
