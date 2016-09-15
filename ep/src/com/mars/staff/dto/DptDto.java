package com.mars.staff.dto;

public class DptDto {
	private String dpt;
	private String dptcd;
	
	public String getDpt() {
		return dpt;
	}
	public void setDpt(String dpt) {
		this.dpt = dpt;
	}
	public String getDptcd() {
		return dptcd;
	}
	public void setDptcd(String dptcd) {
		this.dptcd = dptcd;
	}
	@Override
	public String toString() {
		return "DptDto [dpt=" + dpt + ", dptcd=" + dptcd + "]";
	}
}
