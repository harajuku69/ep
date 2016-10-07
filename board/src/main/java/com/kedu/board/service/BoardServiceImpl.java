package com.kedu.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kedu.board.domain.BoardVo;
import com.kedu.board.domain.SearchParam;
import com.kedu.board.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDao dao;

	@Override
	public List<BoardVo> list(SearchParam param) throws Exception {
		return dao.list(param);
	}

	@Override
	public int cntRec(SearchParam param) {

		return 0;
	}
}
