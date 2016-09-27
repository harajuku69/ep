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
	public void create(BoardDto board) throws Exception {
		session.insert(namespace + ".create", board);
	}

	@Override
	public BoardDto read(Integer bno) throws Exception {
		return session.selectOne(namespace + ".read", bno);
	}

	@Override
	public void update(BoardDto board) throws Exception {
		session.update(namespace + ".update", board);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace + ".delete", bno);
	}

	@Override
	public List<BoardDto> listAll() throws Exception {
		return session.selectList(namespace + ".listAll"); 
	}

	@Override
	public List<BoardDto> listPage(int page) throws Exception {
		if(page <= 0){
			page = 1;
		}
		page = (page - 1) * 10;
		
		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<BoardDto> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}
}
