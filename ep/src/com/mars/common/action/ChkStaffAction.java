package com.mars.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mars.staff.dao.StaffDao;

public class ChkStaffAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/staffDetail.jsp";
		
		HttpSession session = request.getSession();
		String empid = (String)session.getAttribute("ssEmpid");
		String pwd = request.getParameter("pwd");
		
		StaffDao sDao = StaffDao.getInstance();
		
		int result = sDao.loginChk(empid, pwd);
		
//		request.setAttribute("empid", empid);
//		request.setAttribute("result", result);
		
		if(result != 1){
			url = "common/login.jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
