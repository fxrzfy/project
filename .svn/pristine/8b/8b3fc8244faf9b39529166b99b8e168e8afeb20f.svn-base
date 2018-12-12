package com.core.pageModel;

/**
 * 分页对象
 */
public class PageHelper {

	private int page;// 当前页
	private int rows;// 每页显示记录数
	private int pageOffset;// 当前页起始记录
//	private String order;// asc/desc
	private int pageEnd;
	private long total;

	public int getPageEnd() {
		 pageEnd=getPageOffset()+rows;
		 return  pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getPageOffset() {
		pageOffset = (page - 1) * rows;
		return pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

//	public String getOrder() {
//		return order;
//	}
//
//	public void setOrder(String order) {
//		this.order = order;
//	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public DataPage initPageBean(){
		DataPage dataPage=new DataPage<>();
		dataPage.setPage(this.page);
		dataPage.setRows(this.rows);
		//dataPage.setOrder(this.order);
		return dataPage;
	}
	public void initApi(){
		if(0==getRows()){
			setRows(10);
		}
		if(getPage()==0){
			setPage(1);
		}
	}
}
