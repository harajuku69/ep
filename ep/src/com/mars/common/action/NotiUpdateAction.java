package com.mars.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.noti.dao.NotiDao;
import com.mars.noti.dto.NotiDto;

public class NotiUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "noti/adminNotiDetail.jsp";
		
		String pageNo = request.getParameter("pageNo");
		int notino = Integer.parseInt(request.getParameter("notino")); 
				
		NotiDto nDto = new NotiDto();
		nDto.setNotino(notino);
		nDto.setAdmnm(request.getParameter("admnm"));
		nDto.setTit(request.getParameter("tit"));
		nDto.setCtt(request.getParameter("ctt"));
		
		NotiDao nDao = NotiDao.getInstance();
		nDao.updateNoti(nDto);
		
		nDto = nDao.selectOneByNotino(notino);
		request.setAttribute("reqNoti", nDto);
		request.setAttribute("pageNo", pageNo);
		
		List<NotiDto> recentNotiList = nDao.selectAllNoti("1", "4");
		SS.getSS(request).setAttribute("ssRecentNotiList", recentNotiList);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}









