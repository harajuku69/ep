package com.mars.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mars.common.action.SS;
import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class AdminDetailPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/adminDetail.jsp";
		
//		String empid = SS.getEmpid(request) ;
		
		String empid = request.getParameter("empid");
		
		StaffDao sDao = StaffDao.getInstance();
		StaffDto sDto = sDao.selectOneByEmpid(empid);
		
		request.setAttribute("reqStaff", sDto);
		Fmt.toFmtAndReqSet(request, sDto);
		Paging.getRecentList(request);
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
