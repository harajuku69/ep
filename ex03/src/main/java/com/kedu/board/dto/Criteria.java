package com.kedu.board.dto;

public class Criteria {
	private int page;
	private int recPerPage;
	
	public Criteria(){
		this.page = 1;
		this.recPerPage = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0){
			this.page = 1;
		}
		this.page = page;
	}
	public int getRecPerPage() {
		return this.recPerPage;
	}

	public void setRecPerPage(int recPerPage) {
		if(recPerPage <= 0 || recPerPage > 100){
			this.recPerPage = 10;
		}
		this.recPerPage = recPerPage;
	}
	
	public int getSttRec(){
		return (this.page - 1) * recPerPage;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", recPerPage=" + recPerPage + "]";
	}
}
