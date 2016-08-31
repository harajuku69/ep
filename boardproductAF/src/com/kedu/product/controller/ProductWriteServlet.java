package com.kedu.product.controller;

import java.io.IOException;

import com.kedu.product.dao.ProductDao;
import com.kedu.product.dto.ProductDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("product/productWrite.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		post로 넘어오는 request 한글 처리
		request.setCharacterEncoding("UTF-8");
//		파일 업로드 시 실제 디렉토리 확인:1.컨텍스트 정보 확인-ch10 컨텍스트
		ServletContext context = request.getServletContext();
//		실제 디렉토리 확인
		String path = context.getRealPath("upload");
//		한글처리
		String encType = "UTF-8";
//		최대크기 설정
		int sizeLimit = 20 * 1024 * 1024;
		
//		파일 업로드 진행 : 인스턴스 생성-파일업로드 종료
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
//		request 삭제된 상태: multi 처리 필요
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String dsc = multi.getParameter("dsc");
		String product_img = multi.getFilesystemName("product_img");
		String product_img_ori = multi.getOriginalFileName("product_img_ori");
		
//		dto 생성
		ProductDto productDto = new ProductDto();
		productDto.setName(name);
		productDto.setPrice(price);
		productDto.setDsc(dsc);
		productDto.setProduct_img(product_img);
		productDto.setProduct_img_ori(product_img_ori);
		
//		데이터베이스 추가 처리
		ProductDao productDao = ProductDao.getInstance();
		productDao.insertProduct(productDto);
		
		response.sendRedirect("productList.do");
	}

}























