package com.mars.pjt.dto;

public class PskDto {
	private int		pjtno;
	private String	skcd;

	public int getPjtno() {
		return pjtno;
	}
	public void setPjtno(int pjtno) {
		this.pjtno = pjtno;
	}
	public String getSkcd() {
		return skcd;
	}
	public void setSkcd(String skcd) {
		this.skcd = skcd;
	}
	@Override
	public String toString() {
		return "PskDto [pjtno=" + pjtno + ", skcd=" + skcd + "]";
	}
}
