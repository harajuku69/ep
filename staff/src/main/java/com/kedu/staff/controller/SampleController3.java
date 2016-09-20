package com.kedu.staff.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.staff.dto.ProductDto;

@Controller
public class SampleController3 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	@RequestMapping("/doD")
	public String doD(Model model){
		//make sample data
		ProductDto p = new ProductDto("Sample Product", 10000);
		
		logger.info("doD");
		
		model.addAttribute("p",p);
		
		return "productDetail";
	}
}
