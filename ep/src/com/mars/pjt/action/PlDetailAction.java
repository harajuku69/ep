package com.mars.pjt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.mars.common.action.Action;
import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class PlDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empno = request.getParameter("plno");
		
		StaffDto sDto = new StaffDto();
		StaffDao sDao = StaffDao.getInstance();
		sDto = sDao.selectOneByEmpno(empno);
		
		JsonObject json = new JsonObject();
		
		json.addProperty("plnm", sDto.getEmpnm());
		json.addProperty("dpt", sDto.getDptcd());
		json.addProperty("tit", sDto.getTitcd());
		json.addProperty("phone", sDto.getPhone());
		json.addProperty("email", sDto.getEmpid());
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
