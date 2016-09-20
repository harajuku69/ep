package com.kedu.staff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kedu.staff.dto.ProductDto;

@Controller
public class SampleController5 {
	@RequestMapping("/doJSON")
	public @ResponseBody ProductDto doJSON(){
		ProductDto d = new ProductDto("sample", 30000);
		return d;
	}
}
