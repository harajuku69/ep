package com.kedu.board.persistence;

import java.util.List;

import com.kedu.board.domain.BoardVo;
import com.kedu.board.domain.SearchParam;

public interface BoardDao {

	public List<BoardVo> list(SearchParam param)throws Exception;

}
