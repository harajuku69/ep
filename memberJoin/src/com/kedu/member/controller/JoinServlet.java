package com.kedu.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kedu.member.dao.MemberDao;
import com.kedu.member.dto.MemberDto;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("member/join.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setName(name);
		memberDto.setUserid(userid);
		memberDto.setPwd(pwd);
		memberDto.setEmail(email);
		memberDto.setPhone(phone);
		memberDto.setAdmin(Integer.parseInt(admin));
		
		MemberDao memberDao = MemberDao.getInstance();
		int result = memberDao.insertMember(memberDto);
		
		HttpSession session = request.getSession();
		
		if(result == 1){
			session.setAttribute("userid", memberDto.getUserid());
			request.setAttribute("message", "존나 가입 축하한다!");
		} else{
			request.setAttribute("message", "존나 븅신! 가입 실패~~~");
		}
		
		RequestDispatcher disp = request.getRequestDispatcher("member/login.jsp");
		disp.forward(request, response);
	}
}























