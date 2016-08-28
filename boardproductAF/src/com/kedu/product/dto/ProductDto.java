package com.kedu.product.dto;

public class ProductDto {
	
//	1. CODE					Int 		NUMBER(5)
//	2. NAME					String 		VARCHAR2(100)
//	3. PRICE				Int 		NUMBER(8)
//	4. PRODUCT_IMG			String 		VARCHAR2(50)
//	5. PRODUCT_IMG_ORI		String 		VARCHAR2(50)
//	6. DSC					String 		VARCHAR2(1000)
//	
	private Integer code;
	private String name;
	private Integer price;
	private String product_img;
	private String product_img_ori;
	private String dsc;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public String getProduct_img_ori() {
		return product_img_ori;
	}
	public void setProduct_img_ori(String product_img_ori) {
		this.product_img_ori = product_img_ori;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	
	
}
