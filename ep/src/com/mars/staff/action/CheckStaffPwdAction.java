package com.mars.staff.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.common.action.SS;
import com.mars.staff.dao.StaffDao;

public class CheckStaffPwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("pwd");
		String empid = SS.getEmpid(request);
		
		StaffDao sDao = StaffDao.getInstance();
		int result = sDao.checkStaffPwd(empid, pwd);
		
		PrintWriter out = response.getWriter();
		out.print(result);

	}

}
