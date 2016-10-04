package com.kedu.board.dto;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private int 	totRec;
	private int		sttPage;
	private int 	endPage;
	private boolean prev;
	private boolean next;
	
	private int pagePerBlock = 10;
	
	private Criteria cri;
	
	public void setCri(Criteria cri) {
	    this.cri = cri;
	}

	public void setTotCnt(int totRec) {
	    this.totRec = totRec;

	    calcData();
	}

	private void calcData() {
	
	    endPage = (int) (Math.ceil(cri.getPage() / (double) pagePerBlock) * pagePerBlock);
	
	    sttPage = (endPage - pagePerBlock) + 1;
	
	    int tempEndPage = (int) (Math.ceil(totRec / (double) cri.getRecPerPage()));
	
	    if (endPage > tempEndPage) {
	      endPage = tempEndPage;
	    }
	
	    prev = sttPage == 1 ? false : true;
	
	    next = endPage * cri.getRecPerPage() >= totRec ? false : true;
	
	}
	
	  public int getTotalCount() {
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
	
	  public Criteria getCri() {
	    return cri;
	  }
	
	  public String makeQuery(int page) {
	
	    UriComponents uriComponents = 
	    		UriComponentsBuilder.newInstance()
	    		.queryParam("page", page)
	    		.queryParam("recPerPage", cri.getRecPerPage())
	    		.build();
	
	    return uriComponents.toUriString();
	  }
}
