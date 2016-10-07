package com.kedu.board.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kedu.board.domain.BoardVo;
import com.kedu.board.domain.SearchParam;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Inject
	private SqlSession ss;
	
	private static String namespace = "com.kedu.board.mapper.BoardMapper";

	@Override
	public List<BoardVo> list(SearchParam param) throws Exception {
		return ss.selectList(namespace + ".list", param);
	}
	
}
