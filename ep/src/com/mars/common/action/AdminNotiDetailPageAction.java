package com.mars.common.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.noti.dao.NotiDao;
import com.mars.noti.dto.CmtDto;
import com.mars.noti.dto.NotiDto;


public class AdminNotiDetailPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "noti/adminNotiDetail.jsp";

		int notino  = Integer.parseInt(request.getParameter("notino"));
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));
		
		NotiDao nDao = NotiDao.getInstance();

		nDao.updateRdCnt(notino);
		
		NotiDto nDto = nDao.selectOneByNotino(notino);
		request.setAttribute("reqNoti", nDto);
		request.setAttribute("pageNo", pageNo);
		
		String sql = "select count(*) from cmt where notino=" + Integer.toString(notino);
		int cmtPageNo = request.getParameter("cmtPageNo") == null ? 1 : Integer.parseInt(request.getParameter("cmtPageNo"));
		int recPerPage = 5;
		int pagePerBlock = 5;
		
		HashMap<String, Integer> map = new HashMap<>();
		map = Paging.getParam(sql, cmtPageNo, recPerPage, pagePerBlock);
		
		int sttRecNo = map.get("sttRecNo");
		int endRecNo = map.get("endRecNo");
		int cmtcnt = map.get("totRec");
		
		List<CmtDto> cmtList =nDao.selectAllCmt(notino, sttRecNo, endRecNo, cmtcnt);
		
		request.setAttribute("reqCmtList", cmtList);
		request.setAttribute("firstPageNoInBlock", map.get("firstPageNoInBlock"));
		request.setAttribute("lastPageNoInBlock", map.get("lastPageNoInBlock"));
		request.setAttribute("prevPageNo", map.get("prevPageNo"));
		request.setAttribute("nextPageNo", map.get("nextPageNo"));
		request.setAttribute("totPage", map.get("totPage"));
		request.setAttribute("totBlock", map.get("totBlock"));
		request.setAttribute("blockNo", map.get("blockNo"));
		request.setAttribute("cmtPageNo", map.get("pageNo"));
		Paging.getRecentList(request);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
