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
import com.mars.common.action.SS;
import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.CrrDto;
import com.mars.staff.dto.CrtDto;
import com.mars.staff.dto.EduDto;
import com.mars.staff.dto.StaffDto;

public class AdminUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/adminDetail.jsp";
		
//		String empid = SS.getEmpid(request);
		String empid = request.getParameter("empid");
		
		StaffDto sDto = new StaffDto();
		sDto.setDptcd(request.getParameter("dptcd"));
		sDto.setTitcd(request.getParameter("titcd"));
		sDto.setStartdt(Fmt.strToTimestamp(request.getParameter("startdt")));
		sDto.setEnddt(Fmt.strToTimestamp(request.getParameter("enddt")));
		sDto.setSal(Integer.parseInt(request.getParameter("sal")));
		sDto.setAdmchk(Integer.parseInt(request.getParameter("admchk")));
		sDto.setEmpid(empid);
//		System.out.println("업데이트 전 : " +sDto);
		StaffDao sDao = StaffDao.getInstance();
		sDao.updateStaffEmpInfo(sDto);
		//DB에 덥데이트 완료. 이후는 detail 로 가기 위해 다시 정보 가져와서 마는 작업
		
		sDto = sDao.selectOneByEmpid(empid);

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
		
		SS.setDptcd(request, sDto.getDptcd());
		SS.setTitcd(request, sDto.getTitcd());
		
//		Paging.getRecentList(request);
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);

	}

}
