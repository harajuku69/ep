package com.mars.pjt.dto;

import java.util.List;

public class PskDto {
	private int				pskno;
	private int				pjtno;
	private List<String>	skList;
	private String			sk;

	public String getSk() {
		return sk;
	}
	public void setSk(String sk) {
		this.sk = sk;
	}
	public int getPskno() {
		return pskno;
	}
	public void setPskno(int pskno) {
		this.pskno = pskno;
	}
	public int getPjtno() {
		return pjtno;
	}
	public void setPjtno(int pjtno) {
		this.pjtno = pjtno;
	}
	public List<String> getSkList() {
		return skList;
	}
	public void setSkList(List<String> skList) {
		this.skList = skList;
	}
	@Override
	public String toString() {
		return "PskDto [pskno=" + pskno + ", pjtno=" + pjtno + ", skList=" + skList + ", sk=" + sk + "]";
	}
}
