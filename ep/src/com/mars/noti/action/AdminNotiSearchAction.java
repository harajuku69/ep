package com.mars.noti.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.noti.dao.NotiDao;
import com.mars.noti.dto.NotiDto;

public class AdminNotiSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "noti/adminNotiSchList.jsp";
		
		String tit = request.getParameter("tit").trim();
		String ctt = request.getParameter("ctt").trim();
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		NotiDao nDao= NotiDao.getInstance();
		List<NotiDto> notiList = new ArrayList<>();
		
		if(!(tit.isEmpty())){
			notiList = nDao.selectNotiByStr("tit", tit);
		} else if(tit.isEmpty() && !(ctt.isEmpty())){
			notiList = nDao.selectNotiByStr("ctt", ctt);
		} else if(ctt.isEmpty() && !(from.isEmpty())){
			notiList = nDao.selectNotiByDt(from, to);
		}
		
		request.setAttribute("reqNotiList", notiList);
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
