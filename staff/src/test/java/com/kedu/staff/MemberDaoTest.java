package com.kedu.staff;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kedu.staff.dao.MemberDao;
import com.kedu.staff.dto.MemberDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDaoTest {
	@Inject
	private MemberDao dao;
	
	@Test
	public void testTime() throws Exception{
		System.out.println(dao.getTime());
	}
	@Test
	public void testInsertMember() throws Exception{
		MemberDto dto = new MemberDto();
		dto.setUserid("user00");
		dto.setUserpw("user00");
		dto.setUsername("USER00");
		dto.setEmail("user00@aaa.com");
		
		dao.insertMember(dto);
	}
}
