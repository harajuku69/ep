package com.mars.common.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.pjt.dao.PjtDao;
import com.mars.pjt.dto.PmDto;

public class InsertMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pjtno = Integer.parseInt(request.getParameter("pjtno"));
		String empno = request.getParameter("empno");
		String rolecd = request.getParameter("rolecd");
		
		PmDto pmDto = new PmDto();
		pmDto.setPjtno(pjtno);
		pmDto.setEmpno(empno);
		pmDto.setRole(rolecd);
		
		PjtDao pDao = PjtDao.getInstance();
		pDao.insertMember(pmDto);
		
		int result = 1;
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
