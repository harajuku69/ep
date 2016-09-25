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
import com.mars.pjt.dto.SklDto;

public class PjtUpdatePageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "pjt/pjtUpdate.jsp";
		
		int pjtno = Integer.parseInt(request.getParameter("pjtno"));
		String pageNo = request.getParameter("pageNo");
		
		PjtDao pDao = PjtDao.getInstance();
		
		PjtDto pDto = pDao.selectOneByPjtno(pjtno);
		request.setAttribute("reqPjt", pDto);
		
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
		List<PskDto> selPfList = new ArrayList<>();
		List<PskDto> selWebList = new ArrayList<>();
		List<PskDto> selSvrList = new ArrayList<>();
		for(int i=0;i<platform.size();i++){
			selPfList.add(pDao.selectSkNm(platform.get(i)));
		}
		request.setAttribute("reqSelPfList", selPfList);
		
		for(int i=0;i<web.size();i++){
			selWebList.add(pDao.selectSkNm(web.get(i)));
		}
		request.setAttribute("reqSelWebList", selWebList);
		request.setAttribute("sizeOfSelWebList",selWebList.size());
		
		for(int i=0;i<server.size();i++){
			selSvrList.add(pDao.selectSkNm(server.get(i)));
		}
		request.setAttribute("reqSelSvrList", selSvrList);
		request.setAttribute("sizeOfSelSvrList",selSvrList.size());
		
		List<SklDto> sklList = new ArrayList<>();
		
		sklList = pDao.selectAllSkill();
		
		List<SklDto> pfList = new ArrayList<>();
		List<SklDto> webList = new ArrayList<>();
		List<SklDto> svrList = new ArrayList<>();
		for(int i=0;i<sklList.size();i++){
			if(sklList.get(i).getSkcd().charAt(0) == '0'){
				pfList.add(sklList.get(i));
			} else if(sklList.get(i).getSkcd().charAt(0) == '1'){
				webList.add(sklList.get(i));
			} else {
				svrList.add(sklList.get(i));
			}
		}
		
		request.setAttribute("pfList", pfList);
		request.setAttribute("webList", webList);
		request.setAttribute("svrList", svrList);
		
		List<PmDto> pmList = new ArrayList<>();
		pmList = pDao.selectAllPjtMember(pjtno);
		request.setAttribute("reqPjtMemList", pmList);
		
		List<RoleDto> roleList = pDao.selectAllRole();
		request.setAttribute("reqRoleList", roleList);
//		Test
//		for(int i=0;i<3;i++){
//			int[] skl = {11,12,13};
//			int[] sel = {12,13};
//			int cnt = 0;
//			for(int j=0;j<2;j++){
//				if(skl[i] == sel[j]){
//					System.out.println("checked : "+skl[i]);
//				}
//				else{
//					cnt++;
//				}
//			}
//			if(cnt == sel.length){
//				System.out.println("unchecked : "+skl[i]);
//			}
//		}
		request.setAttribute("pageNo", pageNo);
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}













