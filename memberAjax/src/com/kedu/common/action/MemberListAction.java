package com.kedu.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.member.dao.MemberDao;
import com.kedu.member.dto.MemberDto;

public class MemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/memberList.jsp";
		
		MemberDao mDao = MemberDao.getInstance();
		
		List<MemberDto> memberList = mDao.selectAllMembers();
		
		request.setAttribute("memberList", memberList);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
