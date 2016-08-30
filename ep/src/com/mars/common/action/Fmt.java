package com.mars.common.action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.mars.staff.dto.StaffDto;

public class Fmt {
	public static Timestamp strToTimestamp(String date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date udt;
		Timestamp tstp = null;
		try {
			udt = sdf.parse(date.replace("/", "-"));
//			java.sql.Date sdt = new java.sql.Date(udt.getTime()); 
			tstp = new Timestamp(udt.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tstp;		
	}
	public static void toFmtAndReqSet(HttpServletRequest request, StaffDto sDto) {
		String jmf = sDto.getJumin().substring(0, 6);
		String jmb = sDto.getJumin().substring(6, 7)+"******";
		String yyyy = "19";
		String yy = sDto.getJumin().substring(0,2);
		String MM = sDto.getJumin().substring(2,4);
		String dd = sDto.getJumin().substring(4,6);
		String gen ="남";
		int gd = Integer.parseInt(sDto.getJumin().substring(6,7));
		String adm ="일반";
		int admchk = sDto.getAdmchk();
//		System.out.println("SS 안에서 if문 전에는 " + admchk);
		
		if(gd%2 == 0){
			gen="여";
		}
		if(gd <= 2){
			yyyy += yy;
		} else if(gd <= 4){
			yyyy = "20" + yy;
		}
		if(admchk == 1){
			adm = "관리자";
		}
		request.setAttribute("reqStaff", sDto);
		request.setAttribute("jmf", jmf);
		request.setAttribute("jmb", jmb);
		request.setAttribute("yyyy", yyyy);
		request.setAttribute("MM", MM);
		request.setAttribute("dd", dd);
		request.setAttribute("gen", gen);
		request.setAttribute("adm", adm);
	}
}
