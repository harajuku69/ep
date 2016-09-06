package com.mars.common.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.mars.noti.dao.NotiDao;
import com.mars.noti.dto.CmtDto;

public class AdminCmtWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CmtDto cDto = new CmtDto();
		
		cDto.setRegid(SS.getEmpid(request));
		cDto.setNotino(Integer.parseInt(request.getParameter("notino")));
		cDto.setCtt(request.getParameter("ctt"));
		cDto.setPwd(Integer.parseInt(request.getParameter("pwd")));

		NotiDao nDao = NotiDao.getInstance();
		cDto = nDao.writeCmt(cDto);
		
		JsonObject json = new JsonObject();
		json.addProperty("cmtno", cDto.getCmtno());
		json.addProperty("admnm", SS.getAdmnm(request));
		json.addProperty("ctt", cDto.getCtt());
		json.addProperty("regdt", cDto.getRegdt().toString());
//		json.addProperty("admnm", SS.getAdmnm(request));
//		json.addProperty("pwd", cDto.getPwd());
		
		response.setCharacterEncoding("UTF-8");
		Paging.getRecentList(request);
		PrintWriter out = response.getWriter();
		out.print(json);
//		System.out.println("out.print(json)에서 찍음 : " + json);
	}
}
