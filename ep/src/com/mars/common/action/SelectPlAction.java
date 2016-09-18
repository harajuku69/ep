package com.mars.common.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class SelectPlAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empnm = request.getParameter("plnm");
//		System.out.println("zipcdsearchAction plnm : "+plnm);
		StaffDao sDao = StaffDao.getInstance();
		
		List<StaffDto> plList = sDao.selectMemberByEmpnm(empnm);
//		System.out.println(zipcdList);
		String jsonArray = new Gson().toJson(plList);
		
		response.setCharacterEncoding("UTF-8");
		
		Paging.getRecentList(request);
		
		PrintWriter out = response.getWriter();
		out.print(jsonArray);
//		System.out.println(jsonArray);
	}

}
