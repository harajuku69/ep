package com.mars.staff.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.common.action.Fmt;
import com.mars.common.action.Paging;
import com.mars.common.action.SS;
import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class StaffUpdatePageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/staffUpdate.jsp";
		
		String empid = SS.getEmpid(request) ;
		StaffDao sDao = StaffDao.getInstance();
		StaffDto sDto = sDao.selectOneByEmpid(empid);
		
		request.setAttribute("reqStaff", sDto);
		Fmt.toFmtAndReqSet(request, sDto);
		Paging.getRecentList(request);
		
//		SS.getSS(request).setAttribute("ssAdmnm", SS.getAdmnm(request));
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
