package com.kedu.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.product.dao.ProductDao;
import com.kedu.product.dto.ProductDto;

@WebServlet("/productDetail.do")
public class productDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		ProductDao productDao = ProductDao.getInstance();
		ProductDto productDto = productDao.selectProductByCode(code);
		
		request.setAttribute("product", productDto);
		
		RequestDispatcher disp = request.getRequestDispatcher("product/productDetail.jsp"); 
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
