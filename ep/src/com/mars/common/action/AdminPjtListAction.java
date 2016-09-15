package com.mars.common.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.pjt.dao.PjtDao;
import com.mars.pjt.dto.PjtDto;
import com.mars.pjt.dao.PjtDao;
import com.mars.pjt.dto.PjtDto;

public class AdminPjtListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "pjt/adminPjtList.jsp";
		
		String sql = "select count(*) from pjt";
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));
//		int recPerPage = Integer.parseInt(request.getParameter("recPerPage"));
//		int pagePerBlock = Integer.parseInt(request.getParameter("pagePerBlock"));
//		int pageNo = 2;
//		System.out.println(pageNo);
		int recPerPage = 5;
		int pagePerBlock = 5;
		
		HashMap<String, Integer> map = new HashMap<>();
		map = Paging.getParam(sql, pageNo, recPerPage, pagePerBlock);
		
		String sttRecNo = map.get("sttRecNo").toString();
		String endRecNo = map.get("endRecNo").toString();
//		System.out.println(sttRecNo);
//		System.out.println(endRecNo);
//		String pjtno = request.getParameter("pjtno");
		
		PjtDao pDao = PjtDao.getInstance();
		List<PjtDto> pjtList = pDao.selectAllPjt(sttRecNo, endRecNo);
//		System.out.println(pjtList);
		request.setAttribute("reqPjtList", pjtList);
		request.setAttribute("firstPageNoInBlock", map.get("firstPageNoInBlock"));
		request.setAttribute("lastPageNoInBlock", map.get("lastPageNoInBlock"));
		request.setAttribute("prevPageNo", map.get("prevPageNo"));
		request.setAttribute("nextPageNo", map.get("nextPageNo"));
		request.setAttribute("totPage", map.get("totPage"));
		request.setAttribute("totBlock", map.get("totBlock"));
		request.setAttribute("blockNo", map.get("blockNo"));
		request.setAttribute("pageNo", map.get("pageNo"));
		Paging.getRecentList(request);
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
