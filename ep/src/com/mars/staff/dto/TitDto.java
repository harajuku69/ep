package com.mars.staff.dto;

public class TitDto {
	private String tit;
	private String titcd;
	
	public String getTit() {
		return tit;
	}
	public void setTit(String tit) {
		this.tit = tit;
	}
	public String getTitcd() {
		return titcd;
	}
	public void setTitcd(String titcd) {
		this.titcd = titcd;
	}
	@Override
	public String toString() {
		return "TitDto [tit=" + tit + ", titcd=" + titcd + "]";
	}
}
