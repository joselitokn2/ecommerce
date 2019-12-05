package com.wirtz.ecommerce.model.productservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wirtz.ecommerce.model.product.Product;
import com.wirtz.ecommerce.model.product.ProductDao;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	

	@Transactional(readOnly = true)
	public Product findProduct(Long productId) throws InstanceNotFoundException {
		return productDao.find(productId);
	}


	
	@Transactional(readOnly = true)
	public ProductBlock findProductsBlockByKeyword(String keyword, int startIndex, int count) {

		/*
		 * Find count+1  to determine if there exist more items above
		 * the specified range.
		 */
		List<Product> products = productDao.findProductsByKeyword(keyword, startIndex, count+1);
		
		boolean existsMoreItems = products.size() == (count + 1);

		/*
		 * Remove the last item from the returned list if there exist more
		 * items above the specified range.
		 */
		if (existsMoreItems) {
			products.remove(products.size() - 1);
		}

		
		

		ProductBlock productsBlock = new ProductBlock(products, existsMoreItems, startIndex, count, keyword);
		return productsBlock;
	}
}
