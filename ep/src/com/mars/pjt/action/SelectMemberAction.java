package com.mars.pjt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mars.common.action.Action;
import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class SelectMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empnm = request.getParameter("schnm");
		StaffDao sDao = StaffDao.getInstance();
		
		List<StaffDto> plList = sDao.selectMemberByEmpnm(empnm);
		String jsonArray = new Gson().toJson(plList);
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(jsonArray);
	}

}
