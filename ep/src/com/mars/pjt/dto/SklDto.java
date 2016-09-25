package com.mars.pjt.dto;

public class SklDto {
	private String skcd;
	private String sk;
	
	public String getSkcd() {
		return skcd;
	}
	public void setSkcd(String skcd) {
		this.skcd = skcd;
	}
	public String getSk() {
		return sk;
	}
	public void setSk(String sk) {
		this.sk = sk;
	}
	@Override
	public String toString() {
		return "SkDto [skcd=" + skcd + ", sk=" + sk + "]";
	}
}
