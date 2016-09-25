package com.mars.pjt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.pjt.dao.PjtDao;
import com.mars.pjt.dto.PmDto;

public class JoinMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Pjtno = request.getParameter("pjtno");
		int pjtno = Integer.parseInt(Pjtno);
		String empno = request.getParameter("empno");
		String rolecd = request.getParameter("rolecd");
		PjtDao pDao = PjtDao.getInstance();
		
		int result = pDao.checkMember(pjtno, empno);
		
		if(result == 0){
			PmDto pmDto = new PmDto();
			pmDto.setPjtno(pjtno);
			pmDto.setEmpno(empno);
			pmDto.setRole(rolecd);
			
			pDao.insertMember(pmDto);
		} 
			
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
