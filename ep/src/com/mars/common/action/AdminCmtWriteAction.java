package com.mars.common.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.noti.dao.NotiDao;
import com.mars.noti.dto.CmtDto;

public class AdminCmtWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CmtDto cDto = new CmtDto();
		
		String regid = SS.getEmpid(request);
		
		cDto.setNotino(Integer.parseInt(request.getParameter("notino")));
		cDto.setRegid(regid);
		cDto.setCtt(request.getParameter("ctt"));
		cDto.setPwd(Integer.parseInt(request.getParameter("pwd")));
		
		NotiDao nDao = NotiDao.getInstance();
		nDao.writeCmt(cDto);
		
	}

}
