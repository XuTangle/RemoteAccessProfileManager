package domain;

import java.util.List;

/**
 * This is a bean used to encapsulate the data for all the contents needed to be shown in a page
 * @author situh
 *
 */
public class PageBean<T> {
	
	private int currentPage;
	private int totalPage;
	private int pageSize;
	private int totalSize;
	private List<T> list; // This is a list use to contain all the Student objects 
	
	// The constructor which is going to be called in findStudentByPage()
	public PageBean(int currentPage, int totalPage, int pageSize, int totalSize, List<T> list) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		this.list = list;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
