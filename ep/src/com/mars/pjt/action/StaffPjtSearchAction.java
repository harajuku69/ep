package com.mars.pjt.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.pjt.dao.PjtDao;
import com.mars.pjt.dto.PjtDto;

public class StaffPjtSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "pjt/staffPjtSchList.jsp";
		
		String pjtnm = request.getParameter("pjtnm").trim();
		String memnm = request.getParameter("memnm").trim();
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		PjtDao pDao= PjtDao.getInstance();
		List<PjtDto> pjtList = new ArrayList<>();
		
		if(!(pjtnm.isEmpty())){
			pjtList = pDao.selectPjtByPjtnm(pjtnm);
		} else if(pjtnm.isEmpty() && !(memnm.isEmpty())){
			pjtList = pDao.selectPjtByMemnm(memnm);
		} else if(memnm.isEmpty() && !(from.isEmpty())){
			pjtList = pDao.selectPjtByDt(from, to);
		}
		
		request.setAttribute("reqPjtList", pjtList);
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
