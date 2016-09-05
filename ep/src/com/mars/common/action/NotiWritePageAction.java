package com.mars.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotiWritePageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "noti/notiWrite.jsp";
		
//		int notino = Integer.parseInt(request.getParameter("notino"));
//		String pageNo = request.getParameter("pageNo");
		
//		NotiDao nDao = NotiDao.getInstance();
//		NotiDto nDto = nDao.selectOneByNotino(notino);
//		
//		request.setAttribute("reqNoti", nDto);
//		request.setAttribute("pageNo", pageNo);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
