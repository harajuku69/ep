package com.mars.staff.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.common.action.Fmt;
import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.CrrDto;
import com.mars.staff.dto.CrtDto;
import com.mars.staff.dto.DptDto;
import com.mars.staff.dto.EduDto;
import com.mars.staff.dto.StaffDto;
import com.mars.staff.dto.TitDto;

public class AdminUpdatePageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/adminUpdate.jsp";
		
//		String empid = SS.getEmpid(request) ;
		
		String empid = request.getParameter("empid") ;
		
		StaffDao sDao = StaffDao.getInstance();
		StaffDto sDto = sDao.selectOneByEmpid(empid);
		
		List<DptDto> dptList = sDao.selectAllDpt();
		List<TitDto> titList = sDao.selectAllTit();
		
		List<EduDto> eduList = new ArrayList<>();
		eduList = sDao.selectAllEdu(empid);
		
		List<CrrDto> crrList = new ArrayList<>();
		crrList = sDao.selectAllCrr(empid);
		
		List<CrtDto> crtList = new ArrayList<>();
		crtList = sDao.selectAllCrt(empid);
		
		request.setAttribute("reqStaff", sDto);
		request.setAttribute("reqDptList", dptList);
		request.setAttribute("reqTitList", titList);
		request.setAttribute("reqEduList", eduList);
		request.setAttribute("reqCrrList", crrList);
		request.setAttribute("reqCrtList", crtList);
		
		Fmt.toFmtAndReqSet(request, sDto);
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
