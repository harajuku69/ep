package com.mars.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.noti.dao.NotiDao;
import com.mars.noti.dto.NotiDto;

public class NotiListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "noti/notiList.jsp";
		
		NotiDao nDao = NotiDao.getInstance();
		List<NotiDto> notiList = nDao.selectAllNoti();
		
		request.setAttribute("notiList", notiList);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
