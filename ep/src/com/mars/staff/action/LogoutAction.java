package com.mars.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.common.action.IndexAction;
import com.mars.common.action.SS;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		StaffDao sDao = StaffDao.getInstance();
//		sDao.changeAdmstat(SS.getEmpid(request), 0);
		
		SS.getSS(request).invalidate();
		
		new IndexAction().execute(request,response);
	}
}
