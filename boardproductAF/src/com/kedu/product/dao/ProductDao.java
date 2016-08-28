package com.kedu.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kedu.product.dto.ProductDto;

public class ProductDao {
	private ProductDao() {
	
	}
	
	private static ProductDao instance = new ProductDao();
	
	public static ProductDao getInstance(){
		return instance;
	}
	
	public List<ProductDto> selectAllProducts(){
		String sql = "select * from product order by code desc";
		List<ProductDto> list = new ArrayList<ProductDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ProductDto productDto = new ProductDto();
				productDto.setCode(rs.getInt("code"));
				productDto.setName(rs.getString("name"));
				productDto.setPrice(rs.getInt("price"));
				productDto.setProduct_img(rs.getString("product_img"));
				productDto.setProduct_img_ori(rs.getString("product_img_ori"));
				productDto.setDsc(rs.getString("dsc"));
				list.add(productDto);				
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public void insertProduct(ProductDto productDto){
		String sql = "insert into product values(product_seq.nextval, ?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productDto.getName());
			pstmt.setInt(2, productDto.getPrice());
			pstmt.setString(3, productDto.getProduct_img());
			pstmt.setString(4, productDto.getProduct_img_ori());
			pstmt.setString(5, productDto.getDsc());
			pstmt.executeUpdate();			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public ProductDto selectProductByCode(String code){
		String sql = "select * from product where code=?";
		ProductDto productDto = null;
		try{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				rs = pstmt.executeQuery();
				if(rs.next()){
					productDto = new ProductDto();
					productDto.setCode(rs.getInt("code"));
					productDto.setName(rs.getString("name"));
					productDto.setPrice(rs.getInt("price"));
					productDto.setProduct_img(rs.getString("product_img"));
					productDto.setProduct_img_ori(rs.getString("product_img_ori"));
					productDto.setDsc(rs.getString("dsc"));
				}
			} catch(Exception e){
				e.printStackTrace();
			} finally{
				DBManager.close(conn, pstmt, rs);
			}
		} catch(Exception e){
			e.printStackTrace();
		} 
		return productDto;
	}
	
	public void updateProduct(ProductDto productDto){
		String sql = "update product set name=?, price=?, product_img=?, product_img_ori=?, dsc=? where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productDto.getName());
			pstmt.setInt(2, productDto.getPrice());
			pstmt.setString(3, productDto.getProduct_img());
			pstmt.setString(4, productDto.getProduct_img_ori());
			pstmt.setString(5, productDto.getDsc());
			pstmt.setInt(6, productDto.getCode());
			pstmt.executeUpdate();	
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public void deleteProudct(String code){
		String sql = "delete product where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.executeUpdate();	
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	}
}




































