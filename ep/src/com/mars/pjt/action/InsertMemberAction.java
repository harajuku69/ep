package com.mars.pjt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
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
		int result = pDao.insertMember(pmDto);
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
