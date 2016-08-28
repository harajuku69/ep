package com.kedu.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.member.dao.MemberDao;
import com.kedu.member.dto.MemberDto;

@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		MemberDao memberDao = MemberDao.getInstance();
		
		MemberDto memberDto = memberDao.getMember(userid);
		request.setAttribute("memberDto", memberDto);
		
		RequestDispatcher disp = request.getRequestDispatcher("member/memberUpdate.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setUserid(userid);
		memberDto.setPwd(pwd);
		memberDto.setEmail(email);
		memberDto.setPhone(phone);
		memberDto.setAdmin(Integer.parseInt(admin));
		
		MemberDao memberDao = MemberDao.getInstance();
		memberDao.updateMember(memberDto);
		
		response.sendRedirect("login.do");
	}
}























