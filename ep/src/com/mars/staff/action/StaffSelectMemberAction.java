package com.mars.staff.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.common.action.Paging;
import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class StaffSelectMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "staff/staffMemberList.jsp";
		String empnm = request.getParameter("empnm");
		String sql = "select count(*) from staff where empnm like '%' || '" + empnm + "' || '%'";
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));
		int recPerPage = 15;
		int pagePerBlock = 5;
		
		HashMap<String, Integer> map = new HashMap<>();
		map = Paging.getParam(sql, pageNo, recPerPage, pagePerBlock);
		
		String sttRecNo = map.get("sttRecNo").toString();
		String endRecNo = map.get("endRecNo").toString();
		StaffDao sDao = StaffDao.getInstance();
		List<StaffDto> memberList = sDao.selectMemberByEmpnm(empnm, sttRecNo, endRecNo);
		
		request.setAttribute("empnm", empnm);
		request.setAttribute("reqMemberList", memberList);
		request.setAttribute("firstPageNoInBlock", map.get("firstPageNoInBlock"));
		request.setAttribute("lastPageNoInBlock", map.get("lastPageNoInBlock"));
		request.setAttribute("prevPageNo", map.get("prevPageNo"));
		request.setAttribute("nextPageNo", map.get("nextPageNo"));
		request.setAttribute("totPage", map.get("totPage"));
		request.setAttribute("totBlock", map.get("totBlock"));
		request.setAttribute("blockNo", map.get("blockNo"));
		request.setAttribute("pageNo", map.get("pageNo"));
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
