package com.kedu.staff.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kedu.staff.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.kedu.staff.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace + ".getTime");
	}

	@Override
	public void insertMember(MemberDto dto) {
		sqlSession.insert(namespace + ".insertMember", dto);
	}
	//

	@Override
	public MemberDto readMember(String userid) throws Exception {
		return (MemberDto)
		sqlSession.selectOne(namespace + ".selectMember",userid);
	}

	@Override
	public MemberDto readWithPW(String userid, String userpw) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		return sqlSession.selectOne(namespace + ".readWithPW", paramMap) ;
	}
}
