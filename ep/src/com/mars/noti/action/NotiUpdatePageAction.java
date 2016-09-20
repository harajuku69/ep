package com.mars.noti.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.common.action.Paging;
import com.mars.noti.dao.NotiDao;
import com.mars.noti.dto.NotiDto;

public class NotiUpdatePageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "noti/notiUpdate.jsp";
		
		int notino = Integer.parseInt(request.getParameter("notino"));
		String pageNo = request.getParameter("pageNo");
		
		NotiDao sDao = NotiDao.getInstance();
		NotiDto sDto = sDao.selectOneByNotino(notino);
		
		request.setAttribute("reqNoti", sDto);
//		Fmt.toFmtAndReqSet(request, sDto);
		request.setAttribute("pageNo", pageNo);
		Paging.getRecentList(request);
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
