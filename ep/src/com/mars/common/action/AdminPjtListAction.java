package com.mars.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.pjt.dao.PjtDao;
import com.mars.pjt.dto.PjtDto;

public class AdminPjtListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "pjt/adminPjtList.jsp";
		
		PjtDao pDao = PjtDao.getInstance();
		List<PjtDto> pjtList= pDao.selectAllPjt();
		
		request.setAttribute("reqPjtList", pjtList);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
