package com.mars.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class StaffHomePageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/staffHome.jsp";
		
		String empid = SS.getEmpid(request) ;
		StaffDao sDao = StaffDao.getInstance();
		StaffDto sDto = sDao.selectOneByEmpid(empid);
		
//		Fmt.toFmtAndReqSet(request, sDto);
		request.setAttribute("reqStaff", sDto);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
