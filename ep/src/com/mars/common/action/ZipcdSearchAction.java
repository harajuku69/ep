package com.mars.common.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.ZipDto;

import net.sf.json.JSONArray;

public class ZipcdSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kwd = request.getParameter("kwd");
//		System.out.println("zipcdsearchAction kwd : "+kwd);
		StaffDao sDao = StaffDao.getInstance();
		
		List<ZipDto> zipcdList = sDao.selectZipcdListByKwd(kwd);
		
		JSONArray jsonArray = JSONArray.fromObject(zipcdList);
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(jsonArray);
	}

}
