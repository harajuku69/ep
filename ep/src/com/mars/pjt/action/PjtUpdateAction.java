package com.mars.pjt.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.common.action.Fmt;
import com.mars.common.action.Paging;
import com.mars.pjt.dao.PjtDao;
import com.mars.pjt.dto.PjtDto;
import com.mars.pjt.dto.PskDto;

public class PjtUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String url = "pjt/adminPjtDetail.jsp";
		String Pjtno = request.getParameter("pjtno");
		int pjtno = Integer.parseInt(Pjtno);
		
		String url = "pjt.do?cmd=admin_pjt_detail_page&pjtno=" + Pjtno;
		
		PjtDto pDto = new PjtDto();
		PskDto pskDto = new PskDto();
		List<String> skList = new ArrayList<>();
//		PJT 업데이트
		pDto.setStartdt(Fmt.strToTimestamp(request.getParameter("startdt")));
		pDto.setEnddt(Fmt.strToTimestamp(request.getParameter("enddt")));
		pDto.setPjtnm(request.getParameter("pjtnm"));
		pDto.setPjtdtl(request.getParameter("pjtdtl"));
		pDto.setPjtno(pjtno);
//		PJT skill 업데이트
		skList.add(request.getParameter("platform"));
		String[] skset = request.getParameterValues("web");
		for(String web : skset){
			skList.add(web);
		}
		skset = request.getParameterValues("server");
		for(String server : skset){
			skList.add(server);
		}
		pskDto.setPjtno(pjtno);
		pskDto.setSkList(skList);
//		Dao 처리
		PjtDao pDao = PjtDao.getInstance();
		pDao.updatePjt(pDto);
		pDao.updatePjtSkl(pskDto);
		
		Paging.getRecentList(request);
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
