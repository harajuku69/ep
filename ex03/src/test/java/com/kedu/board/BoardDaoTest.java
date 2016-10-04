package com.kedu.board;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.kedu.board.dao.BoardDao;
import com.kedu.board.dto.BoardDto;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class); 
	
	@Inject
	private BoardDao dao;

	@Test
	public void testListPage()throws Exception{
		List<BoardDto> list = dao.listPage(3);
		for(BoardDto board : list){
			logger.info(board.getBno() + ":" + board.getTitle());
		}
	}
}
