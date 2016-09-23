package com.kedu.board.dao;

import java.util.List;

import com.kedu.board.dto.BoardDto;

public interface BoardDao {
	public void create(BoardDto dto) throws Exception;
	
	public BoardDto read(Integer bno) throws Exception;
	
	public void update(BoardDto dto) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardDto> listAll() throws Exception;
}
