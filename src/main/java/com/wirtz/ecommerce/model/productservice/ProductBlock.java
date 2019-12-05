package com.wirtz.ecommerce.model.productservice;

import java.util.List;

import com.wirtz.ecommerce.model.product.Product;
import com.wirtz.ecommerce.model.util.PageBlock;

public class ProductBlock extends PageBlock<Product> {
	private String keyword;

	public ProductBlock(List<Product> items, boolean showNext, int startIndex, int pageCount, String keyWord) {
		super(items, showNext, startIndex, pageCount);
		this.keyword = keyWord;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public void setUrlPattern(String url) {
		this.urlPattern = url;
		this.urlNext = String.format(getUrlPattern(), getStartIndex() + getPageCount(), getPageCount(), this.keyword);
		this.urlPrevious = String.format(getUrlPattern(),
				getStartIndex() - getPageCount() < 0 ? 0 : getStartIndex() - getPageCount(), getPageCount(),
				this.keyword);
	}

}
