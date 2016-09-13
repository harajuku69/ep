package com.mars.common.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.EduDto;

public class AddEduAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EduDto eDto = new EduDto();
		
		eDto.setEmpid(SS.getEmpid(request));
//		eDto.setEduno(Integer.parseInt(request.getParameter("eduno")));
		eDto.setLoc(request.getParameter("loc"));
		eDto.setSchool(request.getParameter("school"));
		eDto.setMajor(request.getParameter("major"));
		eDto.setEnterdt(Fmt.strToTimestamp(request.getParameter("enterdt")));
		eDto.setGraddt(Fmt.strToTimestamp(request.getParameter("graddt")));
		
		StaffDao sDao = StaffDao.getInstance();
		
		int result = sDao.addItem(eDto);
		
		JsonObject json = new JsonObject();
		
		if(result == 1){
			json.addProperty("eduno", eDto.getEduno());
			json.addProperty("loc", eDto.getLoc());
			json.addProperty("school", eDto.getSchool());
			json.addProperty("major", eDto.getMajor());
			json.addProperty("enterdt", eDto.getEnterdt().toString());
			json.addProperty("graddt", eDto.getGraddt().toString());
			
		} else {
			json.addProperty("error", "오류가 발생하였습니다. 다시 등록해주세요");
		}
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
