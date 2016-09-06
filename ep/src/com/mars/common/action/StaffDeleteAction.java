package com.mars.common.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.mars.staff.dto.StaffDto;
import com.mars.staff.dao.StaffDao;

public class StaffDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/staffList.jsp";
		
		String empno = request.getParameter("empno");
		
		StaffDao sDao = StaffDao.getInstance();
		int result = sDao.deleteStaff(empno);
		JsonObject json = new JsonObject();
		
		if(result ==1){
			json.addProperty("msg", "success");
		} else{
			json.addProperty("msg", "fail");
		}
		Paging.getRecentList(request);
		PrintWriter out = response.getWriter();
		out.print(json);
		
//		String sql = "select count(*) from staff";
//		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));
//		int recPerPage = Integer.parseInt(request.getParameter("recPerPage"));
//		int pagePerBlock = Integer.parseInt(request.getParameter("pagePerBlock"));
//		int recPerPage = 4;
//		int pagePerBlock = 5;
//		
//		HashMap<String, Integer> map = new HashMap<>();
//		map = Paging.getParam(sql, pageNo, recPerPage, pagePerBlock);
//		
//		String sttRecNo = map.get("sttRecNo").toString();
//		String endRecNo = map.get("endRecNo").toString();
//		
//		List<StaffDto> staffList = sDao.selectStaffList(sttRecNo, endRecNo);
//		
//		request.setAttribute("reqStaffList", staffList);
//		request.setAttribute("firstPageNoInBlock", map.get("firstPageNoInBlock"));
//		request.setAttribute("lastPageNoInBlock", map.get("lastPageNoInBlock"));
//		request.setAttribute("prevPageNo", map.get("prevPageNo"));
//		request.setAttribute("nextPageNo", map.get("nextPageNo"));
//		request.setAttribute("totPage", map.get("totPage"));
//		request.setAttribute("totBlock", map.get("totBlock"));
//		request.setAttribute("blockNo", map.get("blockNo"));
//		request.setAttribute("pageNo", map.get("pageNo"));
//		
//		RequestDispatcher disp = request.getRequestDispatcher(url);
//		disp.forward(request, response);
	}

}
