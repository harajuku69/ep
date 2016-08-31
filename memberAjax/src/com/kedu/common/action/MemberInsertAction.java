package com.kedu.common.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.kedu.member.dao.MemberDao;
import com.kedu.member.dto.MemberDto;

public class MemberInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println("Insert!!");*/
		MemberDto mDto = new MemberDto();
		
		mDto.setMemnm(request.getParameter("memnm"));
		mDto.setMememail(request.getParameter("mememail"));
		mDto.setMempwd(request.getParameter("mempwd"));
		
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.insertMember(mDto);
		if(result == 1){
			mDto = mDao.lastInsert();
//			System.out.println(mDto);
		}
		
//		JSONObject json = new JSONObject();
		JsonObject json = new JsonObject();
		json.addProperty("no", mDto.getNo());
		json.addProperty("memnm", mDto.getMemnm());
		json.addProperty("mememail", mDto.getMememail());
		json.addProperty("mempwd", mDto.getMempwd());
		
		System.out.println(json.toString());
		response.setContentType("charset=UTF-8");
		//response.setContentType("application/x-json; charset=UTF-8");
//		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
