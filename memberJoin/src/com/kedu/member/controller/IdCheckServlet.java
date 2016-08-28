package com.kedu.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.member.dao.MemberDao;

@WebServlet("/idCheck.do")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IdCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		MemberDao memberDao = MemberDao.getInstance();
		
		int result = memberDao.confirmID(userid);
		
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);
		
		RequestDispatcher disp = request.getRequestDispatcher("member/idcheck.jsp");
		disp.forward(request, response);
	}
}
