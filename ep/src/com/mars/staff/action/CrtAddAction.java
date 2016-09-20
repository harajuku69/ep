package com.mars.staff.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.mars.common.action.Action;
import com.mars.common.action.Fmt;
import com.mars.common.action.SS;
import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.CrtDto;

public class CrtAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid = SS.getEmpid(request);
		CrtDto ctDto = new CrtDto();
		ctDto.setEmpid(empid);
		ctDto.setCrtnm(request.getParameter("crtnm"));
		ctDto.setRank(request.getParameter("rank"));
		ctDto.setPubl(request.getParameter("publ"));
		ctDto.setRegdt(Fmt.strToTimestamp(request.getParameter("regdt")));
		ctDto.setExpdt(Fmt.strToTimestamp(request.getParameter("expdt")));
		StaffDao sDao = StaffDao.getInstance();
		int result = sDao.addCrt(ctDto);
		
		JsonObject json = new JsonObject();
		
		if(result == 1){
			json.addProperty("crtnm", ctDto.getCrtnm());
			json.addProperty("rank", ctDto.getRank());
			json.addProperty("publ", ctDto.getPubl());
			json.addProperty("regdt", ctDto.getRegdt().toString().substring(0, 10));
			json.addProperty("expdt", ctDto.getExpdt().toString().substring(0, 10));
		} else {
			json.addProperty("error", "오류가 발생하였습니다. 다시 등록해주세요.");
		}
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
