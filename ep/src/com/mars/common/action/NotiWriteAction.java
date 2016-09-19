package com.mars.common.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.noti.dao.NotiDao;
import com.mars.noti.dto.NotiDto;

public class NotiWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "noti.do?cmd=admin_noti_list";
		NotiDto nDto = new NotiDto();
		
		nDto.setAdmnm(request.getParameter("admnm"));
		nDto.setTit(request.getParameter("tit"));
		nDto.setCtt(request.getParameter("ctt"));
		
		NotiDao nDao = NotiDao.getInstance();
		nDao.writeNoti(nDto);

		Paging.getRecentList(request);
		response.sendRedirect(url);
	}

}
