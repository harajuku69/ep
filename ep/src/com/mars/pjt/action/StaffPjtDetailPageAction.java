package com.mars.pjt.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.action.Action;
import com.mars.pjt.dao.PjtDao;
import com.mars.pjt.dto.PjtDto;
import com.mars.pjt.dto.PmDto;
import com.mars.pjt.dto.PskDto;
import com.mars.pjt.dto.RoleDto;

public class StaffPjtDetailPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "pjt/staffPjtDetail.jsp";

		int pjtno  = Integer.parseInt(request.getParameter("pjtno"));
		
		PjtDao pDao = PjtDao.getInstance();

		PjtDto pDto = pDao.selectOneByPjtno(pjtno);
		request.setAttribute("reqPjt", pDto);
		
		List<PmDto> pmList = new ArrayList<>();
		pmList = pDao.selectAllPjtMember(pjtno);
		request.setAttribute("reqPjtMemList", pmList);
		
		String sklist = pDao.selectPjtSkByPjtno(pjtno);
		String[] skset = sklist.substring(1,(sklist.length()-1)).split(", ");
		List<String> platform = new ArrayList<>();
		List<String> web = new ArrayList<>();
		List<String> server = new ArrayList<>();
		
		for(int i=0;i<skset.length;i++){
			if(skset[i].charAt(0) == '0'){
				platform.add(skset[i]);
			} else if(skset[i].charAt(0) == '1'){
				web.add(skset[i]);
			} else if(skset[i].charAt(0) == '2'){
				server.add(skset[i]);
			}
		}
		List<PskDto> pfList = new ArrayList<>();
		List<PskDto> webList = new ArrayList<>();
		List<PskDto> svrList = new ArrayList<>();
		for(int i=0;i<platform.size();i++){
			pfList.add(pDao.selectSkNm(platform.get(i)));
		}
		request.setAttribute("reqPfList", pfList);
		for(int i=0;i<web.size();i++){
			webList.add(pDao.selectSkNm(web.get(i)));
		}
		request.setAttribute("reqWebList", webList);
		for(int i=0;i<server.size();i++){
			svrList.add(pDao.selectSkNm(server.get(i)));
		}
		request.setAttribute("reqSvrList", svrList);
		
		List<RoleDto> roleList = new ArrayList<>();
		roleList = pDao.selectAllRole();
		request.setAttribute("reqRoleList", roleList);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
