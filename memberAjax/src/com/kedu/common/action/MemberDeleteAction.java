package com.kedu.common.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.kedu.member.dao.MemberDao;
import com.kedu.member.dto.MemberDto;

public class MemberDeleteAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		MemberDao mDao = MemberDao.getInstance();
		
		int result = mDao.deleteMember(no);
		JsonObject json = new JsonObject();
		if(result ==1){
			json.addProperty("msg", "success");
		} else{
			json.addProperty("msg", "fail");
		}
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
