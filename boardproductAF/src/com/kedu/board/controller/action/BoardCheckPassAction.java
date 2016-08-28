package com.kedu.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.board.dao.BoardDao;
import com.kedu.board.dto.BoardDto;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/checkSuccess.jsp";
		
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		BoardDao bDao = BoardDao.getInstance();
		BoardDto bDto = bDao.selectOneBoardByNum(num);
		
		if(!(bDto.getPass().equals(pass))){
			url = "board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		} 
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
