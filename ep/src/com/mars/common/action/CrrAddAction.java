package com.mars.common.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.CrrDto;

public class CrrAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid = SS.getEmpid(request);
		CrrDto crDto = new CrrDto();
		crDto.setEmpid(empid);
		crDto.setComnm(request.getParameter("comnm"));
		crDto.setDpt(request.getParameter("dpt"));
		crDto.setTit(request.getParameter("tit"));
		crDto.setEmpdt(Fmt.strToTimestamp(request.getParameter("empdt")));
		crDto.setOutdt(Fmt.strToTimestamp(request.getParameter("outdt")));
		StaffDao sDao = StaffDao.getInstance();
		int result = sDao.addCrr(crDto);
		
		JsonObject json = new JsonObject();
		
		if(result == 1){
			json.addProperty("comnm", crDto.getComnm());
			json.addProperty("dpt", crDto.getDpt());
			json.addProperty("tit", crDto.getTit());
			json.addProperty("empdt", crDto.getEmpdt().toString().substring(0, 10));
			json.addProperty("outdt", crDto.getOutdt().toString().substring(0, 10));
		} else {
			json.addProperty("error", "오류가 발생하였습니다. 다시 등록해주세요.");
		}
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
