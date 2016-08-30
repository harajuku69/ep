package com.mars.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class SS {
	public static HttpSession getSS(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return session;
	}
	
	public static String getEmpid(HttpServletRequest request) {
		String ssEmpid = (String)getSS(request).getAttribute("ssEmpid");
		return ssEmpid;
	}
	
	public static String getPwd(HttpServletRequest request) {
		String ssPwd = (String)getSS(request).getAttribute("ssPwd");
		return ssPwd;
	}
	public static int getEmpnm(HttpServletRequest request) {
		int ssEmpnm = (int)getSS(request).getAttribute("ssEmpnm");
		return ssEmpnm;
	}
	
	public static int getAdmnm(HttpServletRequest request) {
		int ssAdmnm = (int)getSS(request).getAttribute("ssAdmnm");
		return ssAdmnm;
	}
	
//	public static StaffDto getDto(HttpServletRequest request) {
//		StaffDto sDto = (StaffDto)getSS(request).getAttribute("ssStaff");
//		return sDto;
//	}
//	public static int getAdmchk(HttpServletRequest request) {
//		int ssAdmchk = (int)getSS(request).getAttribute("ssAdmchk");
//		return ssAdmchk;
//	}
}

