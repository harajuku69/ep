package com.kedu.staff.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.kedu.staff.dto.MemberDto;

public class MemberDaoImple implements MemberDao {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace+"getTime");
	}

	@Override
	public void insertMember(MemberDto dto) {
		sqlSession.insert(namespace+".insertMember", dto);
	}
	//
}
