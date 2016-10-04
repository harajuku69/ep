package com.kedu.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
//	public String common(Exception e){
//		logger.info(e.toString());
//		
//		return "/error/error_common";
//	}
	private ModelAndView errorMAV(Exception e){
		logger.info(e.toString());
		ModelAndView mAV = new ModelAndView();
		mAV.setViewName("/error/error_common");
		mAV.addObject("exception", e);
		return mAV;
	}
}
