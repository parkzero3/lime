package com.lime.account.vo;

public class PageVO {

	private int pageNo;
    private int listScale;
    private int pageScale;
    
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getListScale() {
		return listScale;
	}
	public void setListScale(int listScale) {
		this.listScale = listScale;
	}
	public int getPageScale() {
		return pageScale;
	}
	public void setPageScale(int pageScale) {
		this.pageScale = pageScale;
	}
	@Override
	public String toString() {
		return "PageVO [pageNo=" + pageNo + ", listScale=" + listScale + ", pageScale=" + pageScale + "]";
	}
    
    
}
