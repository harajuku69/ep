package com.mars.pjt.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.common.action.Fmt;
import com.mars.common.action.Paging;
import com.mars.pjt.dao.PjtDao;
import com.mars.pjt.dto.PjtDto;

public class PjtWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "pjt.do?cmd=admin_pjt_list";
		PjtDto pDto = new PjtDto();
		
		pDto.setPjtnm(request.getParameter("pjtnm"));
		pDto.setPjtdtl(request.getParameter("pjtdtl"));
		pDto.setStartdt(Fmt.strToTimestamp(request.getParameter("startdt")));
		pDto.setEnddt(Fmt.strToTimestamp(request.getParameter("enddt")));
//		pDto.setPlnm(request.getParameter("plnm"));
		pDto.setPlid(request.getParameter("plid"));
		
		PjtDao pDao = PjtDao.getInstance();
		pDao.writePjt(pDto);
		
		Paging.getRecentList(request);
		response.sendRedirect(url);

	}

}
