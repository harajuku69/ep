package com.mars.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class StaffListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/staffList.jsp";
		
		StaffDao sDao = StaffDao.getInstance();
		List<StaffDto> staffList = sDao.selectAllStaff();
		
		request.setAttribute("staffList", staffList);
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
