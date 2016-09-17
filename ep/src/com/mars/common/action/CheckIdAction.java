package com.mars.common.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.mars.staff.dao.StaffDao;

public class CheckIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid = request.getParameter("id");
		StaffDao sDao = StaffDao.getInstance();
		
		int result = sDao.chkId(empid);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		json.addProperty("empid", empid);
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
