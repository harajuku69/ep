package com.mars.staff.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.common.action.ActionFactory;

@WebServlet("/staff.do")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public StaffServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println("StaffServlet에서 요청을 받음 : " + cmd);
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(cmd);
		
		if(action != null){
			action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
