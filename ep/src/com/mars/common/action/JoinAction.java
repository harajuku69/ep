package com.mars.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "common/login.jsp";
		StaffDto sDto = new StaffDto();
		
		sDto.setEmpnm(request.getParameter("empnm"));
		sDto.setEmpid(request.getParameter("empid"));
		sDto.setPwd(request.getParameter("pwd"));
		
		StaffDao sDao = StaffDao.getInstance();
		int result = sDao.insertStaff(sDto);
//		System.out.println("1:성공, 0:실패 => " + result);
		if(result != 1){
			url = "common/join.jsp";
			request.setAttribute("msg", "회원가입에 실패했습니다. 다시 작성해주세요.");
		}
		request.setAttribute("msg", "축하합니다. 회원 가입되었습니다.");

		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
