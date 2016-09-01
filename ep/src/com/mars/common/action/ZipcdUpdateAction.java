package com.mars.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class ZipcdUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/staffUpdate.jsp";
		String no = request.getParameter("no");
		
		StaffDao sDao = StaffDao.getInstance();
		//updateZipcd함수에서 업데이트 처리도 하고 addr 스트링도 만들어서 같이 업데이트 한다.
		String empid = (String)SS.getEmpid(request);
		sDao.updateZipcd(no, empid);
		
//		StaffDto sDto = new StaffDto();
//		sDto = sDao.selectOneByEmpid(empid);
//		Fmt.toFmtAndReqSet(request, sDto);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
