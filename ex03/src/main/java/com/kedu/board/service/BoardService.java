package com.kedu.board.service;

import java.util.List;

import com.kedu.board.dto.BoardDto;
import com.kedu.board.dto.Criteria;

public interface BoardService {
	public void insert(BoardDto board) throws Exception;

	public List<BoardDto> listAll() throws Exception;

	public BoardDto detail(int bno) throws Exception;
	
	public void delete(int bno) throws Exception;

	public void update(BoardDto board)throws Exception;
	
	public List<BoardDto> listCri(Criteria cri) throws Exception;

	public int recCnt(Criteria cri) throws Exception;
}
