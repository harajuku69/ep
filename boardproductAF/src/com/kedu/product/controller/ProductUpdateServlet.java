package com.kedu.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.product.dao.ProductDao;
import com.kedu.product.dto.ProductDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		ProductDao productDao = ProductDao.getInstance();
		ProductDto productDto = productDao.selectProductByCode(code);
		
		request.setAttribute("product", productDto);
		
		RequestDispatcher disp = request.getRequestDispatcher("product/productUpdate.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		//아래 code는 jsp에서  hidden으로 넘겨준 데이터
		String code = multi.getParameter("code");
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String dsc = multi.getParameter("dsc");
		String product_img = multi.getParameter("product_img");
		String product_img_ori = multi.getParameter("product_img_ori");
		
		//nonmakeImg도 hidden으로 넘어간 데이터
		if(product_img == null){
			product_img = multi.getParameter("nonmakeImg");
		}
		
		ProductDto productDto = new ProductDto();
		productDto.setCode(Integer.parseInt(code));
		productDto.setName(name);
		productDto.setPrice(price);
		productDto.setDsc(dsc);
		productDto.setProduct_img(product_img);
		productDto.setProduct_img_ori(product_img_ori);
		
		ProductDao productDao = ProductDao.getInstance();
		productDao.updateProduct(productDto);
		
		response.sendRedirect("productList.do");
	}

}
