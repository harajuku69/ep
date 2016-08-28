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

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") != null){
			url = "common/main.jsp";
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDao memberDao = MemberDao.getInstance();
		int result = memberDao.userCheck(userid, pwd);
		
		if(result == 1){
			MemberDto memberDto = memberDao.getMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", memberDto);
			request.setAttribute("message", "회원가입에 성공했습니다.");
			url = "common/main.jsp";
		} else if(result == 0){
			String tempid = request.getParameter("userid");
			request.setAttribute("userid", tempid);
			request.setAttribute("message", "장난하냐? 비밀번호 틀리다~~");
			
		} else if(result == -1){
			request.setAttribute("message", "없는 아이디인데? 확그냥");
		}
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}
}






















