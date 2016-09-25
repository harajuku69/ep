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
import com.mars.pjt.dto.SklDto;

public class PjtWritePageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "pjt/pjtWrite.jsp";
		
		List<SklDto> sklList = new ArrayList<>();
		PjtDao pDao = PjtDao.getInstance();
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
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);

	}

}
