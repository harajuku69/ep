package com.mars.common.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.EduDto;
import com.mars.staff.dto.StaffDto;

public class StaffDetailPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/staffDetail.jsp";
		
		String empid = request.getParameter("empid");
		StaffDao sDao = StaffDao.getInstance();
		StaffDto sDto = sDao.selectOneByEmpid(empid);
		
		List<EduDto> eduList = new ArrayList<>();
		eduList = sDao.selectAllEdu(empid);
		
		request.setAttribute("reqEduList", eduList);
		request.setAttribute("reqStaff", sDto);
		Fmt.toFmtAndReqSet(request, sDto);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
