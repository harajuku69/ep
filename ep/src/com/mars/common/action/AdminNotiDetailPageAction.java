package com.mars.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.noti.dao.NotiDao;
import com.mars.noti.dto.NotiDto;


public class AdminNotiDetailPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "noti/adminNotiDetail.jsp";
		
		String notino = request.getParameter("notino");
		String pageNo = request.getParameter("pageNo");
		
		NotiDao nDao = NotiDao.getInstance();
		NotiDto nDto = nDao.selectOneByNotino(notino);
		
		request.setAttribute("reqNoti", nDto);
		request.setAttribute("pageNo", pageNo);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
