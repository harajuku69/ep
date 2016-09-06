package com.mars.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.staff.dao.StaffDao;

public class ChkIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid = request.getParameter("empid");
		
		StaffDao sDao = StaffDao.getInstance();
		
		int result = sDao.chkId(empid);
		
		request.setAttribute("empid", empid);
		request.setAttribute("result", result);
		Paging.getRecentList(request);
		RequestDispatcher disp = request.getRequestDispatcher("common/chkId.jsp");
		disp.forward(request, response);
	}

}
