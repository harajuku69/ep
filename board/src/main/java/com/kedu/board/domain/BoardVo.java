package com.kedu.board.domain;

import java.util.Date;

public class BoardVo {
	private int		bno;
	private String	tit;
	private String	ctt;
	private String	writer;
	private Date	regdt;
	private int		rdcnt;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTit() {
		return tit;
	}
	public void setTit(String tit) {
		this.tit = tit;
	}
	public String getCtt() {
		return ctt;
	}
	public void setCtt(String ctt) {
		this.ctt = ctt;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdt() {
		return regdt;
	}
	public void setRegdt(Date regdt) {
		this.regdt = regdt;
	}
	public int getRdcnt() {
		return rdcnt;
	}
	public void setRdcnt(int rdcnt) {
		this.rdcnt = rdcnt;
	}
	@Override
	public String toString() {
		return "BoardVo [bno=" + bno + ", tit=" + tit + ", ctt=" + ctt + ", writer=" + writer + ", regdt=" + regdt
				+ ", rdcnt=" + rdcnt + "]";
	}
}
