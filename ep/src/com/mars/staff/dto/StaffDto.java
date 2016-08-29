package com.mars.staff.dto;

import java.sql.Timestamp;

public class StaffDto {
	private String  	empid;
	private String  	pwd;
	private String  	empno;
	private String  	empnm;
	private String  	email;
	private String  	phone;
	private String  	jumin;
//	private Timestamp	bdt;
//	private int			gd;
	private String  	pic;
	private String  	zipcd;
	private String  	addr;
	private String  	addrdtl;
	private String  	dpt;
	private String  	tit;
	private int			sal;
	private Timestamp	startdt;
	private Timestamp	enddt;
	private Timestamp	regdt;
	private String		lastdt;
	private String		logdt;
	private String		admchk;
	private String		admnm;
	
	public String getAdmnm() {
		return admnm;
	}
	public void setAdmnm(String admnm) {
		this.admnm = admnm;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEmpnm() {
		return empnm;
	}
	public void setEmpnm(String empnm) {
		this.empnm = empnm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
//	public Timestamp getBdt() {
//		return bdt;
//	}
//	public void setBdt(Timestamp bdt) {
//		this.bdt = bdt;
//	}
//	public int getGd() {
//		return gd;
//	}
//	public void setGd(int gd) {
//		this.gd = gd;
//	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getZipcd() {
		return zipcd;
	}
	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddrdtl() {
		return addrdtl;
	}
	public void setAddrdtl(String addrdtl) {
		this.addrdtl = addrdtl;
	}
	public String getDpt() {
		return dpt;
	}
	public void setDpt(String dpt) {
		this.dpt = dpt;
	}
	public String getTit() {
		return tit;
	}
	public void setTit(String tit) {
		this.tit = tit;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Timestamp getStartdt() {
		return startdt;
	}
	public void setStartdt(Timestamp startdt) {
		this.startdt = startdt;
	}
	public Timestamp getEnddt() {
		return enddt;
	}
	public void setEnddt(Timestamp enddt) {
		this.enddt = enddt;
	}
	public Timestamp getRegdt() {
		return regdt;
	}
	public void setRegdt(Timestamp regdt) {
		this.regdt = regdt;
	}	
	public String getLastdt() {
		return lastdt;
	}
	public void setLastdt(String lastdt) {
		this.lastdt = lastdt;
	}
	public String getLogdt() {
		return logdt;
	}
	public void setLogdt(String logdt) {
		this.logdt = logdt;
	}	
	public String getAdmchk() {
		return admchk;
	}
	public void setAdmchk(String admchk) {
		this.admchk = admchk;
	}
	@Override
	public String toString() {
		return "StaffDto [empid=" + empid + ", empno=" + empno + ", empnm=" + empnm + ", dpt=" + dpt + ", tit=" + tit
				+ ", lastdt=" + lastdt + ", logdt=" + logdt + ", admchk=" + admchk + "]";
	}
}
