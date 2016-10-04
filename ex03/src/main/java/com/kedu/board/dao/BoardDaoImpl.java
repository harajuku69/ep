package com.kedu.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kedu.board.dto.BoardDto;
import com.kedu.board.dto.Criteria;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kedu.board.mapper.BoardMapper";
	
	@Override
	public void insert(BoardDto board) throws Exception {
		session.insert(namespace + ".insert",board);
	}

	@Override
	public List<BoardDto> listAll() throws Exception {
		return session.selectList(namespace + ".selectAll");
	}

	@Override
	public BoardDto detail(int bno) throws Exception {
		return session.selectOne(namespace + ".selectOne", bno);
	}

	@Override
	public void delete(int bno) throws Exception {
		session.delete(namespace + ".delete", bno);
	}

	@Override
	public void update(BoardDto board) throws Exception {
		session.update(namespace + ".update", board);
	}

	@Override
	public List<BoardDto> listPage(int page) throws Exception {
		
		if(page <= 0){
			page = 1;
		}
		page = (page-1)*10;
		
		return session.selectList(namespace + ".select", page);
	}

	@Override
	public List<BoardDto> listCri(Criteria cri) throws Exception {
		return session.selectList(namespace + ".selectCri", cri);
	}

	@Override
	public int recCnt(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".selectCnt", cri);
	}
}
