package com.mars.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class StaffUpdateAction extends HttpServlet implements Action{

	private static final long serialVersionUID = 1L;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/staffDetail.jsp";
		
		request.setCharacterEncoding("UTF-8");
		 
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
//		String pwd = multi.getParameter("pwd");
		String phone = multi.getParameter("phone");
//		String zipcd = multi.getParameter("zipcd");
		String addr = multi.getParameter("addr");
		String addrdtl = multi.getParameter("addrdtl");
		String pic = multi.getParameter("pic");
		String empid = SS.getEmpid(request);
		StaffDto sDto = new StaffDto();
		
		sDto.setEmpid(empid);
//		sDto.setPwd(pwd);
		sDto.setPhone(phone);
//		sDto.setZipcd(zipcd);
		sDto.setAddr(addr);
		sDto.setAddrdtl(addrdtl);
		sDto.setPic(pic);
		
		StaffDao sDao = StaffDao.getInstance();
		sDao.updateStaff(sDto);
		
		response.sendRedirect(url);
//		RequestDispatcher disp = request.getRequestDispatcher(url);
//		disp.forward(request, response);
	}

}




























