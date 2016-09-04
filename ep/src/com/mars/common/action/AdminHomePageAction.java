package com.mars.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class AdminHomePageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/adminHome.jsp";
		
		String empid = SS.getEmpid(request) ;
//		String toStat = request.getParameter("toStat");
		
		StaffDao sDao = StaffDao.getInstance();
//		sDao.updateStat(empid, toStat);
		
		StaffDto sDto = sDao.selectOneByEmpid(empid);
		
//		Fmt.toFmtAndReqSet(request, sDto);
		request.setAttribute("reqStaff", sDto);
//		request.setAttribute("currStat", toStat);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
