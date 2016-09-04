package com.mars.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SS {
	public static HttpSession getSS(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return session;
	}
	
	public static String getEmpid(HttpServletRequest request) {
		String ssEmpid = (String)getSS(request).getAttribute("ssEmpid");
		return ssEmpid;
	}
	
	public static int getEmpnm(HttpServletRequest request) {
		int ssEmpnm = (int)getSS(request).getAttribute("ssEmpnm");
		return ssEmpnm;
	}
	
	public static int getAdmnm(HttpServletRequest request) {
		int ssAdmnm = (int)getSS(request).getAttribute("ssAdmnm");
		return ssAdmnm;
	}
	
	public static int getAdmchk(HttpServletRequest request) {
		int ssAdmchk = (int)getSS(request).getAttribute("ssAdmchk");
		return ssAdmchk;
	}
	
	public static void setDptcd(HttpServletRequest request, String dptcd){
		getSS(request).setAttribute("ssDptcd", dptcd);
	}
	
	public static void setTitcd(HttpServletRequest request, String titcd){
		getSS(request).setAttribute("ssTitcd", titcd);
	}
}

//	public static void setCurrStat(HttpServletRequest request, String currStat){
//		getSS(request).setAttribute("ssCurrStat", currStat);
//	}
//	
//	public static int getCurrStat(HttpServletRequest request) {
//		int currStat = (int)getSS(request).getAttribute("ssCurrStat");
//		return currStat;
//	}

//	public static String getPwd(HttpServletRequest request) {
//		String ssPwd = (String)getSS(request).getAttribute("ssPwd");
//		return ssPwd;
//	}