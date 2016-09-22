package com.mars.noti.dto;

import java.sql.Timestamp;

public class CmtDto {
	private int cmtno;
	private int notino;
	private String regid;
	private String regnm;
	private String ctt;
	private int pwd;
	private Timestamp regdt;
	private int delchk;
	private int rpno;
	
	public int getRpno() {
		return rpno;
	}
	public void setRpno(int rpno) {
		this.rpno = rpno;
	}
	public int getCmtno() {
		return cmtno;
	}
	public void setCmtno(int cmtno) {
		this.cmtno = cmtno;
	}
	public int getNotino() {
		return notino;
	}
	public void setNotino(int notino) {
		this.notino = notino;
	}
	public String getRegnm() {
		return regnm;
	}
	public void setRegnm(String regnm) {
		this.regnm = regnm;
	}
	public String getRegid() {
		return regid;
	}
	public void setRegid(String regid) {
		this.regid = regid;
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
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	public int getDelchk() {
		return delchk;
	}
	public void setDelchk(int delchk) {
		this.delchk = delchk;
	}
	@Override
	public String toString() {
		return "CmtDto [cmtno=" + cmtno + ", notino=" + notino + ", rpno=" + rpno + ", regnm=" + regnm + ", regid="
				+ regid + ", ctt=" + ctt + ", regdt=" + regdt + ", pwd=" + pwd + ", delchk=" + delchk + "]";
	}
}
