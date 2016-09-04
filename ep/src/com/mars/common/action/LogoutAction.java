package com.mars.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mars.staff.dao.StaffDao;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		StaffDao sDao = StaffDao.getInstance();
		
//		String empid = SS.getEmpid(request);
//		String toStat = "-1";
//		sDao.updateStat(empid,toStat);
		
//		HttpSession session = request.getSession();
//		session.invalidate();
		
		SS.getSS(request).invalidate();
		
		RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
		disp.forward(request, response);
	}

}
