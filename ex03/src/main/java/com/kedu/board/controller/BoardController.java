package com.kedu.board.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kedu.board.dto.BoardDto;
import com.kedu.board.dto.Criteria;
import com.kedu.board.dto.PageMaker;
import com.kedu.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject 
	private BoardService service;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void registerGET(BoardDto board, Model model){
		logger.info("register get............");
	}
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerPOST(BoardDto board, RedirectAttributes rttr) throws Exception{
		logger.info("register post .........");
		logger.info(board.toString());
		
		service.insert(board);
		
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/board/listPage";
	}
//	@RequestMapping(value="/listAll", method = RequestMethod.GET)
//	public void listAll(Model model) throws Exception{
//		logger.info("show all list................");
//		model.addAttribute("list",service.listAll());
//	}
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public void detail(@RequestParam("bno") int bno, Model model) throws Exception{
		logger.info("show one article................");
		model.addAttribute(service.detail(bno));
	}
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
		logger.info("delete an article................");
		service.delete(bno);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public void update(@RequestParam("bno") int bno, Model model) throws Exception{
		logger.info("going to update page................");
		model.addAttribute(service.detail(bno));
	}
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(BoardDto board, RedirectAttributes rttr ) throws Exception{
		logger.info("update an article................");
		service.update(board);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/listPage";
	}
//	@RequestMapping(value="/listCri", method = RequestMethod.GET)
//	public void listCri(Criteria cri, Model model) throws Exception{
//		logger.info("show list page with criteria............");
//		model.addAttribute("list", service.listCri(cri));
//	}
	@RequestMapping(value="/listPage", method = RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception{
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listCri(cri));
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotCnt(service.recCnt(cri));
		model.addAttribute("pm",pm);
	}
	
	
}
