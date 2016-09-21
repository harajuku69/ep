package com.mars.pjt.dto;

public class PmDto {
	private int		pjtno;
	private String	empno;
	private String  memnm;
	private String  dpt;
	private String  tit;
	private String	role;

	public int getPjtno() {
		return pjtno;
	}
	public void setPjtno(int pjtno) {
		this.pjtno = pjtno;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getMemnm() {
		return memnm;
	}
	public void setMemnm(String memnm) {
		this.memnm = memnm;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "PmDto [pjtno=" + pjtno + ", empno=" + empno + ", memnm=" + memnm + ", dpt=" + dpt + ", tit=" + tit
				+ ", role=" + role + "]";
	}
}
