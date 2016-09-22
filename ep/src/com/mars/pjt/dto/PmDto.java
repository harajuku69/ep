package com.mars.pjt.dto;

public class PmDto {
	private int		pjtno;
	private String	empid;
	private String	rolecd;
	
	public int getPjtno() {
		return pjtno;
	}
	public void setPjtno(int pjtno) {
		this.pjtno = pjtno;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getRolecd() {
		return rolecd;
	}
	public void setRolecd(String rolecd) {
		this.rolecd = rolecd;
	}
	@Override
	public String toString() {
		return "PmgDto [pjtno=" + pjtno + ", empid=" + empid + ", rolecd=" + rolecd + "]";
	}
}
