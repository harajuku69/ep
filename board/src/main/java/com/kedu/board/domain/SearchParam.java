package com.kedu.board.domain;

public class SearchParam extends Param {
	private String kwd;
	private String type;
	
	public String getKwd() {
		return kwd;
	}
	public void setKwd(String kwd) {
		this.kwd = kwd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "SearchParam [kwd=" + kwd + ", type=" + type + "]";
	}
}
