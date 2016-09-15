package com.mars.common.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.mars.staff.dao.StaffDao;

public class CrtDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int crtno = Integer.parseInt(request.getParameter("crtno"));
		
		StaffDao sDao = StaffDao.getInstance();
		
		int result = sDao.deleteCrt(crtno);
		
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
