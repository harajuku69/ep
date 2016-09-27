package com.kedu.board;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.kedu.board.dao.BoardDao;
import com.kedu.board.dto.BoardDto;
import com.kedu.board.dto.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);
	
	@Inject
	private BoardDao dao;
	
	@Test
	public void testCreate() throws Exception {
		BoardDto board = new BoardDto();
		board.setTitle("새로운 제목을 넣습니다.");
		board.setContent("새로운 글을 넣습니다.");
		board.setWriter("user00");
		dao.create(board);
	}
	
	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(4).toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardDto board = new BoardDto();
		board.setBno(4);
		board.setTitle("수정된 글입니다");
		board.setContent("수정 테스트");
		dao.update(board);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(5);
	}
	
	@Test
	public void testListPage() throws Exception {
		int page = 3;
		
		List<BoardDto> list = dao.listPage(page);
		
		for(BoardDto board : list){
			logger.info(board.getBno() + ":" + board.getTitle());
		}
	}
	@Test
	public void testListCriteria() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardDto> list = dao.listCriteria(cri);
		
		for(BoardDto board : list){
			logger.info(board.getBno() + ":" + board.getTitle());
		}
	}
	@Test
	public void testURI() throws Exception {
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.path("/board/read")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build();
		
		logger.info("/board/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}
	@Test
	public void testURI2() throws Exception {
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.path("/{module}/{page}")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build()
				.expand("board","read")
				.encode();
		
		logger.info("/board/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}
}












