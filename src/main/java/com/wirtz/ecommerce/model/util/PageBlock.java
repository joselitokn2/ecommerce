package com.wirtz.ecommerce.model.util;

import java.util.List;

public class PageBlock<E> {
	
	private int startIndex;
	private int pageCount;

	
	private List<E> items;
	
	private boolean showNext;
	private boolean showPrevious;
	
	protected String urlPattern;
	
	public void setUrlNext(String urlNext) {
	//On purpose empty;
	}
	public void setUrlPrevious(String urlPrevious) {
	//	On purpose empty;
	}
	public String getUrlNext() {
		return urlNext;
	}
	public String getUrlPrevious() {
		return urlPrevious;
	}

	protected String urlNext;
	protected String urlPrevious;
	
	public PageBlock(List<E> items, boolean showNext, int startIndex, int pageCount) {
		super();
		this.items = items;
		this.showNext = showNext;
		
		this.startIndex= startIndex;
		this.pageCount= pageCount;
		
		this.showPrevious = startIndex>=pageCount;
		
	}
	public List<E> getItems() {
		return items;
	}
	public void setItems(List<E> items) {
		this.items = items;
	}
	public boolean getShowNext() {
		return showNext;
	}
	public void setShowNext(boolean existsMoreItems) {
		this.showNext = existsMoreItems;
	}
	
	public boolean isShowPrevious() {
		return showPrevious;
	}
	public void setShowPrevious(boolean showPrevious) {
		this.showPrevious = showPrevious;
	}
	

	public String getUrlPattern() {
		return urlPattern;
	}
	public void setUrlPattern(String url) {
		this.urlPattern = url;
	
		this.urlNext= String.format(urlPattern, startIndex+pageCount, pageCount);
		this.urlPrevious=String.format(urlPattern, startIndex-pageCount <0?0:startIndex-pageCount, pageCount);
	}
	
//	public void setCurrentPage(int currentPage) {
//		this.currentPage = currentPage;
//	}
//
//	public void setTotalPages(int totalPages) {
//		this.totalPages = totalPages;
//	}
	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
//	public int getCurrentPage() {
//		currentPage =  (startIndex % pageCount)+1;
//		return currentPage;
//	}
//	
//	public int getTotalPages() {
//		totalPages= (totalNumber % pageCount) > 0 ? (totalNumber % pageCount)+1: (totalNumber % pageCount);
//		return totalPages;
//	}
	
//	public PageBlock(int startIndex, int pageCount, List<E> lista, int totalNumber) {
//		super();
//		this.startIndex = startIndex;
//		this.pageCount = pageCount;
//		this.lista = lista;
//		this.totalNumber= totalNumber;
//	}
//
//	
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
//
//	public List<E> getLista() {
//		return lista;
//	}
//
//	public void setLista(List<E> lista) {
//		this.lista = lista;
//	}
//	public int getTotalNumber() {
//		return totalNumber;
//	}
//
//	public void setTotalNumber(int totalNumber) {
//		this.totalNumber = totalNumber;
//	}
}
