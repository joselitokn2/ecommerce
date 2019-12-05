package com.wirtz.ecommerce.model.product;

import java.util.List;

import com.wirtz.ecommerce.modelutil.dao.GenericDao;

public interface ProductDao extends GenericDao<Product, Long>{




	public List<Product> findProductsByKeyword( String keyword, int startIndex, int count) ;
	
	}


