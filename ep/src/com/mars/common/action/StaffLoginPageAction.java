package com.mars.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;

public class StaffLoginPageAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/staffLogin.jsp";
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}
}
