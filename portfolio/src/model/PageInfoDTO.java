package model;

public class PageInfoDTO {

	private int page; // 현재 페이지
	private int maxPage; // 총 페이지 
	private int startPage; // 첫번째 페이지번호
	private int endPage; // 마지막 페이지번호
	private int listCount; // 총 게시물 개수
	
	public void setPage(int page) {
		this.page = page;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	
	public int getPage() {
		return page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public int getListCount() {
		return listCount;
	}
	
}
