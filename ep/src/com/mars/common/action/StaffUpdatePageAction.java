package com.mars.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class StaffUpdatePageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/staffUpdate.jsp";
		
		/*String empid = request.getParameter("empid");
		
		StaffDao sDao = StaffDao.getInstance();
		
		StaffDto sDto = sDao.selectOneByEmpid(empid);
		
		String jmf = sDto.getJumin().substring(0, 6);
		String jmb = sDto.getJumin().substring(6, 7)+"******";
		String yyyy = "19";
		String yy;
		String MM;
		String dd;
		String gen ="남";
		int gd;
		
		yy = sDto.getJumin().substring(0,2);
		MM = sDto.getJumin().substring(2,4);
		dd = sDto.getJumin().substring(4,6);
		gd = Integer.parseInt(sDto.getJumin().substring(6,7));
		
		if(gd <= 2){
			yyyy += yy;
			if(gd%2 == 0){
				gen="여";
			}
		} else if(gd <= 4){
			yyyy="20" + yy;
			if(gd%2 == 0){
				gen="여";
			}
		}
		
		request.setAttribute("ssStaff", sDto);
		request.setAttribute("jmf", jmf);
		request.setAttribute("jmb", jmb);
		request.setAttribute("yyyy", yyyy);
		request.setAttribute("MM", MM);
		request.setAttribute("dd", dd);
		request.setAttribute("gen", gen);*/
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
