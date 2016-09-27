package com.kedu.board.service;

import java.util.List;

import com.kedu.board.dto.BoardDto;
import com.kedu.board.dto.Criteria;

public interface BoardService {
	public void regist(BoardDto board) throws Exception;
	
	public BoardDto read(Integer bno)  throws Exception;
	
	public void modify(BoardDto board) throws Exception;
	
	public void remove(Integer bno) throws Exception;
	
	public List<BoardDto> listAll() throws Exception;
	
	public List<BoardDto> listCriteria(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;
}
