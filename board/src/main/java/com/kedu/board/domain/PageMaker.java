package com.kedu.board.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


public class PageMaker {
	private int 	totRec;
	private int		sttPage;
	private int 	endPage;
	private boolean prev;
	private boolean next;
	
	private int pagePerBlock = 10;
	
	private Param param;
	
	public void setParam(Param param) {
	    this.param = param;
	}

	public void setTotRec(int totRec) {
	    this.totRec = totRec;

	    calcData();
	}

	private void calcData() {
	
	    endPage = (int) (Math.ceil(param.getPage() / (double) pagePerBlock) * pagePerBlock);
	
	    sttPage = (endPage - pagePerBlock) + 1;
	
	    int tempEndPage = (int) (Math.ceil(totRec / (double) param.getRecPerPage()));
	
	    if (endPage > tempEndPage) {
	      endPage = tempEndPage;
	    }
	
	    prev = sttPage == 1 ? false : true;
	
	    next = endPage * param.getRecPerPage() >= totRec ? false : true;
	
	}
	
	public int getTotCnt() {
	  return totRec;
	}
	
	public int getSttPage() {
	  return sttPage;
	}
	
	public int getEndPage() {
	  return endPage;
	}
	
	public boolean isPrev() {
	  return prev;
	}
	
	public boolean isNext() {
	  return next;
	}
	
	public int getPagePerBlock() {
	  return pagePerBlock;
	}
	
	public Param getParam() {
	  return param;
	}
	
	public String makeQuery(int page) {
	
	  UriComponents uriComponents = 
	  		UriComponentsBuilder.newInstance()
	  		.queryParam("page", page)
	  		.queryParam("recPerPage", param.getRecPerPage())
	  		.build();
	
	  return uriComponents.toUriString();
	}
	
	public String makeSearch(int page){
		    
		UriComponents uriComponents =
			UriComponentsBuilder.newInstance()
			.queryParam("page", page)
			.queryParam("recPerPage", param.getRecPerPage())
			.queryParam("type", ((SearchParam)param).getType())
			.queryParam("kwd", ((SearchParam)param).getKwd())
			.build();             
		
		return uriComponents.toUriString();
	} 
}
