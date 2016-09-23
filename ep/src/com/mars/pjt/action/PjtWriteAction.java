package com.mars.pjt.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.common.action.Fmt;
import com.mars.common.action.Paging;
import com.mars.pjt.dao.PjtDao;
import com.mars.pjt.dto.PjtDto;
import com.mars.pjt.dto.PmDto;
import com.mars.pjt.dto.PskDto;

public class PjtWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "pjt.do?cmd=admin_pjt_list";
		PjtDto pDto = new PjtDto();
		PskDto pskDto = new PskDto();
		PmDto pmDto = new PmDto();
		List<String> skList = new ArrayList<>();
		
		String plno = request.getParameter("plno"); 
//		PJT 등록
		pDto.setPjtnm(request.getParameter("pjtnm"));
		pDto.setPjtdtl(request.getParameter("pjtdtl"));
		pDto.setStartdt(Fmt.strToTimestamp(request.getParameter("startdt")));
		pDto.setEnddt(Fmt.strToTimestamp(request.getParameter("enddt")));
		pDto.setPlno(plno);
//		PJT skill 등록
		skList.add(request.getParameter("platform"));
		String[] skset = request.getParameterValues("web");
		for(String web : skset){
			skList.add(web);
		}
		skset = request.getParameterValues("svr");
		for(String svr : skset){
			skList.add(svr);
		}
		pskDto.setSkList(skList);
//		System.out.println(skList);
//		PJT member 등록
		pmDto.setEmpno(plno);
		pmDto.setRole("00");
		
//		Dao 처리
		PjtDao pDao = PjtDao.getInstance();
		pDao.regPjt(pDto);
		pDao.regPjtSkl(pskDto);
		pDao.regPjtMember(pmDto);
		
		Paging.getRecentList(request);
		response.sendRedirect(url);

	}

}

