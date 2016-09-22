package com.mars.staff.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.common.action.SS;
import com.mars.staff.dao.StaffDao;

public class CheckStaffPwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("pwd");
		String empid = SS.getEmpid(request);
//		System.out.println(pwd);
		
		StaffDao sDao = StaffDao.getInstance();
		int result = sDao.checkStaffPwd(empid, pwd);
//		System.out.println(result);
		
//		String msg = "비밀번호가 일치하지 않습니다";
//		
//		if(result == 1){
//			msg = "비밀번호가 일치합니다";
//		} 
		
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write(new Gson().toJson(msg));
		
		PrintWriter out = response.getWriter();
		out.print(result);
//		System.out.println(result);

	}

}
