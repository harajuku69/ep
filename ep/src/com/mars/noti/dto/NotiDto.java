package com.mars.noti.dto;

import java.sql.Timestamp;

public class NotiDto {
	private int 		notino;
	private String 		admnm;
	private String		tit;
	private String		ctt;
	private Timestamp	regdt;
	private int 		rdcnt;
	private int			delchk;
	
	public int getNotino() {
		return notino;
	}
	public void setNotino(int notino) {
		this.notino = notino;
	}
	public String getAdmnm() {
		return admnm;
	}
	public void setAdmnm(String admnm) {
		this.admnm = admnm;
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
	public Timestamp getRegdt() {
		return regdt;
	}
	public void setRegdt(Timestamp regdt) {
		this.regdt = regdt;
	}
	public int getRdcnt() {
		return rdcnt;
	}
	public void setRdcnt(int readcnt) {
		this.rdcnt = readcnt;
	}
	public int getDelchk() {
		return delchk;
	}
	public void setDelchk(int delchk) {
		this.delchk = delchk;
	}
	@Override
	public String toString() {
		return "NotiDto [notino=" + notino + ", admnm=" + admnm + ", tit=" + tit + ", regdt=" + regdt + ", readcnt="
				+ rdcnt + ", delchk=" + delchk + "]";
	}
}
