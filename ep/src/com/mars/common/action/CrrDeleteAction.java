package com.mars.common.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.mars.staff.dao.StaffDao;

public class CrrDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int crrno = Integer.parseInt(request.getParameter("crrno"));
		
		StaffDao sDao = StaffDao.getInstance();
		
		int result = sDao.deleteCrr(crrno);
		
		JsonObject json = new JsonObject();
		
		if(result == 1){
			json.addProperty("msg", "success");
		} else {
			json.addProperty("msg", "fail");
		}
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}