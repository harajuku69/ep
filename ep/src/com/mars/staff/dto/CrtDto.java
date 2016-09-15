package com.mars.staff.dto;

import java.sql.Timestamp;

public class CrtDto {
	String		empid;
	int			crtno;
	String		crtnm;
	String		rank;
	String		publ;
	Timestamp	regdt;
	Timestamp	expdt;
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public int getCrtno() {
		return crtno;
	}
	public void setCrtno(int crtno) {
		this.crtno = crtno;
	}
	public String getCrtnm() {
		return crtnm;
	}
	public void setCrtnm(String crtnm) {
		this.crtnm = crtnm;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getPubl() {
		return publ;
	}
	public void setPubl(String publ) {
		this.publ = publ;
	}
	public Timestamp getRegdt() {
		return regdt;
	}
	public void setRegdt(Timestamp regdt) {
		this.regdt = regdt;
	}
	public Timestamp getExpdt() {
		return expdt;
	}
	public void setExpdt(Timestamp expdt) {
		this.expdt = expdt;
	}
	@Override
	public String toString() {
		return "CrtDto [empid=" + empid + ", crtno=" + crtno + ", crtnm=" + crtnm + ", rank=" + rank + ", publ=" + publ
				+ ", regdt=" + regdt + ", expdt=" + expdt + "]";
	}
}
