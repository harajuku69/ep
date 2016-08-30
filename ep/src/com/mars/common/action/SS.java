package com.mars.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mars.staff.dto.StaffDto;

public class SS {
	public static HttpSession getSS(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return session;
	}
	public static void toFmt(HttpServletRequest request) {
		StaffDto sDto = (StaffDto)getSS(request).getAttribute("ssStaff") ;
		String jmf = sDto.getJumin().substring(0, 6);
		String jmb = sDto.getJumin().substring(6, 7)+"******";
		String yyyy = "19";
		String yy;
		String MM;
		String dd;
		String gen ="남";
		int gd;
//		String admchk ="일반";
		
		System.out.println("SS 안에서 if문 전에는 " + sDto.getAdmchk());
		yy = sDto.getJumin().substring(0,2);
		MM = sDto.getJumin().substring(2,4);
		dd = sDto.getJumin().substring(4,6);
		gd = Integer.parseInt(sDto.getJumin().substring(6,7));
		
		if(gd <= 2){
			yyyy += yy;
			if(gd%2 == 0){
				gen="여";
			}
		} else if(gd <= 4){
			yyyy="20" + yy;
			if(gd%2 == 0){
				gen="여";
			}
		}
//		if(sDto.getAdmchk()=="1"){
//			admchk = "관리자";
//		}
		request.setAttribute("jmf", jmf);
		request.setAttribute("jmb", jmb);
		request.setAttribute("yyyy", yyyy);
		request.setAttribute("MM", MM);
		request.setAttribute("dd", dd);
		request.setAttribute("gen", gen);
//		request.setAttribute("admchk", admchk);
//		System.out.println("SS toFmt : admchk = " + request.getAttribute("admchk"));
	}
	
	public static String getEmpid(HttpServletRequest request) {
		String ssEmpid = (String)getSS(request).getAttribute("ssEmpid");
		return ssEmpid;
	}
	
	public static int getAdmchk(HttpServletRequest request) {
		int admchk = (int)getSS(request).getAttribute("ssAdmchk");
		return admchk;
	}
	
	public static StaffDto getDto(HttpServletRequest request) {
		StaffDto sDto = (StaffDto)getSS(request).getAttribute("ssStaff");
		return sDto;
	}
}
