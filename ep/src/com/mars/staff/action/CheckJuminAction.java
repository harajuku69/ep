package com.mars.staff.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.mars.common.action.Action;
import com.mars.staff.dao.StaffDao;

public class CheckJuminAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String jmf = request.getParameter("jmf");
		 String jmb = request.getParameter("jmb");
		 String jumin = jmf + jmb;
		 StaffDao sDao = StaffDao.getInstance();
		
		int result = sDao.chkJm(jumin);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		json.addProperty("jmf", jmf);
		json.addProperty("jmb", jmb);
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
