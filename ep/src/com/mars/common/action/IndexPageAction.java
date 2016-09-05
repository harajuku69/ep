package com.mars.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.noti.dao.NotiDao;
import com.mars.noti.dto.NotiDto;
import com.mars.pjt.dao.PjtDao;
import com.mars.pjt.dto.PjtDto;

public class IndexPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp";
		
//		String sttRecNo = "1";
//		String endRecNo = "4";
//
//		//noti 최근 글 가져오는 action
//		NotiDao nDao = NotiDao.getInstance();
//		List<NotiDto> recentNotiList = nDao.selectAllNoti(sttRecNo, endRecNo);
//				
//		SS.getSS(request).setAttribute("ssRecentNotiList", recentNotiList);
//		System.out.println(recentNotiList);
//		//pjt 최근 글 가져오는 action
//		PjtDao pDao = PjtDao.getInstance();
//		List<PjtDto> recentPjtList = pDao.selectAllPjt(sttRecNo, endRecNo);
//				
//		SS.getSS(request).setAttribute("ssRecentPjtList", recentPjtList);
		
		Paging.getRecentList(request);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
