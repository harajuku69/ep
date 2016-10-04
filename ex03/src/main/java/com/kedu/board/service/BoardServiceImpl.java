package com.kedu.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kedu.board.dao.BoardDao;
import com.kedu.board.dto.BoardDto;
import com.kedu.board.dto.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	public BoardDao dao;
	
	@Override
	public void insert(BoardDto board) throws Exception {
		dao.insert(board);
	}

	@Override
	public List<BoardDto> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public BoardDto detail(int bno) throws Exception {
		return dao.detail(bno);
	}

	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public void update(BoardDto board) throws Exception {
		dao.update(board);
	}

	@Override
	public List<BoardDto> listCri(Criteria cri) throws Exception {
		return dao.listCri(cri);
	}

	@Override
	public int recCnt(Criteria cri) throws Exception {
		return dao.recCnt(cri);
	}

}
