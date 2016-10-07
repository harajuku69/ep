package com.kedu.board.service;

import java.util.List;

import com.kedu.board.domain.BoardVo;
import com.kedu.board.domain.SearchParam;

public interface BoardService {

	public List<BoardVo> list(SearchParam param)throws Exception;

	public int cntRec(SearchParam param);
	
}
