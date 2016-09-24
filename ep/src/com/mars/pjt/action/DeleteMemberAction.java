package com.mars.pjt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.pjt.dao.PjtDao;

public class DeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empno = request.getParameter("empno");

		PjtDao pDao = PjtDao.getInstance();
		int result = pDao.deleteMember(empno);
//		System.out.println(result);
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}









