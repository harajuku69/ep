package com.mars.noti.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.mars.common.action.Action;
import com.mars.common.action.Paging;
import com.mars.common.action.SS;
import com.mars.noti.dao.NotiDao;
import com.mars.noti.dto.CmtDto;

public class CmtWriteAction implements Action {

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
		json.addProperty("rpno", cDto.getRpno());
//		json.addProperty("admnm", SS.getAdmnm(request));
		json.addProperty("regnm", cDto.getRegnm());
		json.addProperty("ctt", cDto.getCtt());
		json.addProperty("regdt", cDto.getRegdt().toString());
		
		response.setCharacterEncoding("UTF-8");
		Paging.getRecentList(request);
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
