package com.kedu.board.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kedu.board.domain.PageMaker;
import com.kedu.board.domain.SearchParam;
import com.kedu.board.service.BoardService;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService svc;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void list(@ModelAttribute("param") SearchParam param, Model md) throws Exception{
		logger.info(param.toString());
		
		md.addAttribute("list", svc.list(param));
		PageMaker pm = new PageMaker();
		pm.setParam(param);
		pm.setTotRec(svc.cntRec(param));
		md.addAttribute("pm", pm);
	}

}
