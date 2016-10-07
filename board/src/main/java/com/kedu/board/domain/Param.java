package com.kedu.board.domain;

public class Param {
	private int page;
	private int recPerPage;
	private int sttRec;
	
	public Param() {
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
		return recPerPage;
	}

	public void setRecPerPage(int recPerPage) {
		if(recPerPage <= 0 || recPerPage > 100){
			this.recPerPage = 10;
		}
		this.recPerPage = recPerPage;
	}

	public int getSttRec() {
		return sttRec;
	}

	public void setSttRec() {
		this.sttRec = (page-1) * recPerPage;
	}

	@Override
	public String toString() {
		return "Param [page=" + page + ", recPerPage=" + recPerPage + ", sttRec=" + sttRec + "]";
	}
}
