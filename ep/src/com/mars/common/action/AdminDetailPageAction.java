package com.mars.common.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mars.common.action.SS;
import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.CrrDto;
import com.mars.staff.dto.CrtDto;
import com.mars.staff.dto.EduDto;
import com.mars.staff.dto.StaffDto;

public class AdminDetailPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/adminDetail.jsp";
		
//		String empid = SS.getEmpid(request) ;
		
		String empid = request.getParameter("empid");
		
		StaffDao sDao = StaffDao.getInstance();
		StaffDto sDto = sDao.selectOneByEmpid(empid);
		
		List<EduDto> eduList = new ArrayList<>();
		eduList = sDao.selectAllEdu(empid);
		
		List<CrrDto> crrList = new ArrayList<>();
		crrList = sDao.selectAllCrr(empid);
		
		List<CrtDto> crtList = new ArrayList<>();
		crtList = sDao.selectAllCrt(empid);
		
		request.setAttribute("reqStaff", sDto);
		request.setAttribute("reqEduList", eduList);
		request.setAttribute("reqCrrList", crrList);
		request.setAttribute("reqCrtList", crtList);
		Fmt.toFmtAndReqSet(request, sDto);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
