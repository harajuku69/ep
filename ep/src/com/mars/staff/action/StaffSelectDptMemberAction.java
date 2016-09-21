package com.mars.staff.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.common.action.SS;
import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class StaffSelectDptMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/staffDptMemberList.jsp";
		
		String dpt = request.getParameter("dpt");
		
		StaffDao sDao = StaffDao.getInstance();
		List<StaffDto> staffList = sDao.selectAllStaffByDpt(dpt);
		StaffDto sDto = sDao.selectOneByEmpid(SS.getEmpid(request));
		
		request.setAttribute("reqStaffList", staffList);
		request.setAttribute("reqStaff", sDto);
		request.setAttribute("reqDpt", dpt);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
