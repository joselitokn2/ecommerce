package com.wirtz.ecommerce.model.productservice;

import com.wirtz.ecommerce.model.product.Product;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;

public interface ProductService {
	

	public Product findProduct(Long productId)throws InstanceNotFoundException;


	
	public ProductBlock findProductsBlockByKeyword(String keyword, int
			startIndex, int count);
}
