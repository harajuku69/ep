package com.mars.noti.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.mars.common.action.Action;
import com.mars.noti.dao.NotiDao;

public class CmtDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cmtno = Integer.parseInt(request.getParameter("cmtno"));
		
		NotiDao nDao = NotiDao.getInstance();
		int result = nDao.deleteCmt(cmtno);
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
