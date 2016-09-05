package com.mars.common.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mars.staff.dao.StaffDao;
import com.mars.staff.dto.StaffDto;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String url = "staff/staffHome.jsp";
		String empid = request.getParameter("empid");
		String pwd = request.getParameter("pwd");
//		String toStat = request.getParameter("toStat");
		
		StaffDao sDao = StaffDao.getInstance();
		int result = sDao.loginChk(empid, pwd);
//		System.out.println("result : "+result);
		
		if(result == 1){
			StaffDto sDto = sDao.selectOneByEmpid(empid);
			String lastdt = sDto.getLogdt();
			if(lastdt == null){
				lastdt = "첫 로그인입니다"; 
				sDao.updateLogdt(empid, lastdt);
			}
			sDao.updateLogdt(empid, lastdt);
			
//			sDao.updateStat(empid,toStat);
			
			//로그인 정보를 업데이트한 정보를 다시 가져와서 sDto에 저장
			sDto = sDao.selectOneByEmpid(empid);
			
			HttpSession session = request.getSession();
//			session.setAttribute("ssStaff", sDto);
			session.setAttribute("ssEmpid", sDto.getEmpid());
			session.setAttribute("ssEmpnm", sDto.getEmpnm());
			session.setAttribute("ssEmpno", sDto.getEmpno());
			session.setAttribute("ssPwd", sDto.getPwd());
			session.setAttribute("ssPic", sDto.getPic());
//			session.setAttribute("ssJumin", sDto.getJumin());
			session.setAttribute("ssAdmnm", sDto.getAdmnm());
			session.setAttribute("ssAdmchk", sDto.getAdmchk());
			session.setAttribute("ssLastdt", sDto.getLastdt());
			session.setAttribute("ssDptcd", sDto.getDptcd());
			session.setAttribute("ssTitcd", sDto.getTitcd());
//			System.out.println(sDto.getJumin());
//			System.out.println(sDto.getEmpid());
//			Fmt.toFmtAndReqSet(request, sDto);
			request.setAttribute("reqStaff", sDto);
//			request.setAttribute("currStat", sDto.getStat());
			
		} else if(result == 0){
			request.setAttribute("msg", "입력한 비밀번호가 틀립니다~");
			request.setAttribute("empid", empid);
			url = "common/login.jsp";
		} else if(result == -1){
			request.setAttribute("msg", "존재하지 않는 아이디입니다~");
			url = "common/login.jsp";
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}
}
