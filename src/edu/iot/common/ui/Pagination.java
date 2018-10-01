package edu.iot.common.ui;

import java.util.ArrayList;
import java.util.List;

public class Pagination<T> {
	
	final static int PER_PAGE = 10;		// 한 페이지당 데이터 건수

	List<T> list;						// 전체 리스트
	int totalCount;						// 전체 데이터 건수
	int totalPage;						// 전체 페이지 수
	int page;							// 현재 페이지
	
	public Pagination(List<T> list){
		this.list = list;
		totalCount = list.size();
		totalPage = (int) Math.ceil((double) totalCount/ PER_PAGE);
		page = 1;
	}
	
	public List<T> getPage(int page) {
		this.page = page;
		
		List<T> pageList = new ArrayList<>();
		int start = (page - 1) * PER_PAGE;
		int end = start + PER_PAGE;
		if(end > list.size()) {			// 마지막 페이지일 경우
			end = list.size();
		}
		for(int i = start; i < end; i++) {
			pageList.add(list.get(i));
		}
		return pageList;
	}
	
	public List<T> getPage(){
		return getPage(page);
	}
	
	public int previous() {
		page = (page == 1) ? totalPage : page - 1;
		return page;
	}
	
	public int next() {
		page = (page == totalPage) ? 1 : page + 1;
		return page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void printPages() {
		for(int i = 1; i <= totalPage; i++) {
			if(page == i) {
				System.out.printf("[%d] ", i);
			} else {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}
